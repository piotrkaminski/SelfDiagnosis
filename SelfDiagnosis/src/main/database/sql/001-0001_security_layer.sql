sp_rename 'User', 'SystemUser';
GO

CREATE TABLE [dbo].[SecurityRole](
    [id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
    [roleName] [nvarchar](50) NULL,
 CONSTRAINT [PK_SecurityRole] PRIMARY KEY CLUSTERED 
(
    [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


CREATE TABLE [dbo].[SystemUserSecurityRole](
    [systemUser_id] [numeric](19, 0) NOT NULL,
    [securityRole_id] [numeric](19, 0) NOT NULL,
 CONSTRAINT [PK_SystemUserSecurityRole] PRIMARY KEY CLUSTERED 
(
    [systemUser_id], [securityRole_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[SystemUserSecurityRole]  WITH CHECK ADD  CONSTRAINT [FK_SystemUserSecurityRole_User] FOREIGN KEY([systemUser_id])
REFERENCES [dbo].[SystemUser] ([id])
GO

ALTER TABLE [dbo].[SystemUserSecurityRole] CHECK CONSTRAINT [FK_SystemUserSecurityRole_User]
GO

ALTER TABLE [dbo].[SystemUserSecurityRole]  WITH CHECK ADD  CONSTRAINT [FK_SystemUserSecurityRole_SecurityRole] FOREIGN KEY([securityRole_id])
REFERENCES [dbo].[SecurityRole] ([id])
GO

ALTER TABLE [dbo].[SystemUserSecurityRole] CHECK CONSTRAINT [FK_SystemUserSecurityRole_SecurityRole]
GO

INSERT INTO [dbo].[SecurityRole](roleName) VALUES ('ROLE_USER');
INSERT INTO [dbo].[SecurityRole](roleName) VALUES ('ROLE_ADMINISTRATOR');
GO

-- Initial user
INSERT INTO [dbo].[SystemUser](firstName, lastName, email, password) VALUES ('Test', 'Test', 'test@sd.com', 'test1234');
GO


BEGIN
DECLARE @user_id numeric;
DECLARE @securityRole_id numeric;

SELECT @user_id = id FROM [dbo].[SystemUser] WHERE [email] = 'test@sd.com';
SELECT @securityRole_id = id from [dbo].[SecurityRole] WHERE [roleName] = 'ROLE_USER';

INSERT INTO [dbo].[SystemUserSecurityRole](systemUser_id, securityRole_id) 
    VALUES (@user_id, @securityRole_id);

SELECT @securityRole_id = id from [dbo].[SecurityRole] WHERE [roleName] = 'ROLE_ADMINISTRATOR';

INSERT INTO [dbo].[SystemUserSecurityRole](systemUser_id, securityRole_id) 
    VALUES (@user_id, @securityRole_id);
    
END
GO

ALTER TABLE [dbo].[SystemUser] DROP COLUMN tel;
ALTER TABLE [dbo].[SystemUser] DROP COLUMN zipCode;
ALTER TABLE [dbo].[SystemUser] DROP COLUMN address;
ALTER TABLE dbo.[SystemUser] ADD enabled int NOT NULL DEFAULT 1;
GO

-- password 'test1234' encoded using sha
UPDATE [dbo].[SystemUser] set password = '9bc34549d565d9505b287de0cd20ac77be1d3f2c' where [email] = 'test@sd.com';
