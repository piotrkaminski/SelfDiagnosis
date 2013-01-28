USE [master]
GO
/****** Object:  Database [SelfDiagnosis]    Script Date: 2013-01-28 22:49:38 ******/
CREATE DATABASE [SelfDiagnosis]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SelfDiagnosis', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.DEV\MSSQL\DATA\SelfDiagnosis.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'SelfDiagnosis_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.DEV\MSSQL\DATA\SelfDiagnosis_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [SelfDiagnosis] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SelfDiagnosis].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SelfDiagnosis] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET ARITHABORT OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [SelfDiagnosis] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SelfDiagnosis] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SelfDiagnosis] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SelfDiagnosis] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SelfDiagnosis] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [SelfDiagnosis] SET  MULTI_USER 
GO
ALTER DATABASE [SelfDiagnosis] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SelfDiagnosis] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SelfDiagnosis] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SelfDiagnosis] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [SelfDiagnosis]
GO
/****** Object:  Table [dbo].[BodyPart]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BodyPart](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
 CONSTRAINT [PK_BodyPart] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Contraindication]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Contraindication](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[description] [varchar](max) NULL,
 CONSTRAINT [PK_Contraindication] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Disease]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Disease](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[description] [varchar](max) NULL,
	[frequency] [smallint] NOT NULL,
 CONSTRAINT [PK_Disease] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DiseaseDoctorSpeciality]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DiseaseDoctorSpeciality](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[disease_id] [numeric](19, 0) NOT NULL,
	[doctorSpeciality_id] [int] NOT NULL,
	[note] [varchar](200) NULL,
 CONSTRAINT [PK_DiseaseDoctorSpeciality] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DiseaseDrug]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiseaseDrug](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[disease_id] [numeric](19, 0) NOT NULL,
	[drug_id] [numeric](19, 0) NOT NULL,
 CONSTRAINT [PK_DiseaseDrug] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DiseaseSymptom]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiseaseSymptom](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[disease_id] [numeric](19, 0) NOT NULL,
	[symptom_id] [numeric](19, 0) NOT NULL,
	[rank] [smallint] NOT NULL,
	[frequency] [smallint] NOT NULL,
 CONSTRAINT [PK_DiseaseSymptom] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DiseaseTreatment]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DiseaseTreatment](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[disease_id] [numeric](19, 0) NOT NULL,
	[treatment_id] [numeric](19, 0) NOT NULL,
	[note] [varchar](200) NULL,
 CONSTRAINT [PK_DiseaseTreatment] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DoctorSpeciality]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DoctorSpeciality](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[descrption] [varchar](max) NULL,
 CONSTRAINT [PK_DoctorSpeciality] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Drug]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Drug](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[description] [varchar](200) NULL,
 CONSTRAINT [PK_Drug] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DrugContraindication]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DrugContraindication](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[drug_id] [numeric](19, 0) NOT NULL,
	[contraindication_id] [numeric](19, 0) NOT NULL,
	[note] [varchar](200) NULL,
 CONSTRAINT [PK_DrugContraindication] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Symptom]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Symptom](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[description] [varchar](max) NULL,
	[bodyPart_id] [int] NOT NULL,
 CONSTRAINT [PK_Symptom] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SymptomQuestion]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SymptomQuestion](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[symptom_id] [numeric](19, 0) NOT NULL,
	[questionNumer] [smallint] NOT NULL,
	[question] [varchar](max) NOT NULL,
 CONSTRAINT [PK_SymptomQuestion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SymptomQuestionAnswer]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SymptomQuestionAnswer](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[symptomQuestion_id] [numeric](19, 0) NOT NULL,
	[answerNumer] [smallint] NOT NULL,
	[answer] [varchar](200) NOT NULL,
 CONSTRAINT [PK_SymptomQuestionAnswer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Test]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Test](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[description] [varchar](max) NULL,
	[testType_id] [int] NOT NULL,
	[minimumValue] [numeric](18, 4) NULL,
	[maximumValue] [numeric](18, 4) NULL,
	[testUnit_id] [int] NULL,
	[validForDays] [int] NULL,
	[cost] [int] NULL,
 CONSTRAINT [PK_Test] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TestFlag]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TestFlag](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](20) NOT NULL,
	[desciption] [varchar](100) NULL,
 CONSTRAINT [PK_TestFlag] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TestType]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TestType](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[description] [varchar](max) NULL,
 CONSTRAINT [PK_TestType] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TestUnit]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TestUnit](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[shortName] [varchar](10) NULL,
 CONSTRAINT [PK_TestUnit] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Treatment]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Treatment](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[description] [varchar](max) NULL,
 CONSTRAINT [PK_Treatment] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[User]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[User](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[firstName] [varchar](50) NULL,
	[lastName] [varchar](50) NULL,
	[email] [varchar](100) NULL,
	[tel] [varchar](30) NULL,
	[zipCode] [varchar](10) NULL,
	[city] [varchar](50) NULL,
	[address] [varchar](50) NULL,
	[signInDate] [datetime] NULL,
	[lastLogIn] [datetime] NULL,
	[password] [varchar](50) NULL,
	[ip] [varchar](30) NULL,
	[gender] [varchar](1) NULL,
	[birthDate] [date] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[UserTest]    Script Date: 2013-01-28 22:49:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserTest](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[user_id] [numeric](19, 0) NOT NULL,
	[test_id] [numeric](19, 0) NOT NULL,
	[testValue] [numeric](18, 4) NULL,
	[testUnit_id] [int] NULL,
	[testFlag_id] [int] NULL,
	[testDate] [datetime] NULL,
 CONSTRAINT [PK_UserTest] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[DiseaseDoctorSpeciality]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseDoctorSpeciality_Disease] FOREIGN KEY([disease_id])
REFERENCES [dbo].[Disease] ([id])
GO
ALTER TABLE [dbo].[DiseaseDoctorSpeciality] CHECK CONSTRAINT [FK_DiseaseDoctorSpeciality_Disease]
GO
ALTER TABLE [dbo].[DiseaseDoctorSpeciality]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseDoctorSpeciality_DoctorSpeciality] FOREIGN KEY([doctorSpeciality_id])
REFERENCES [dbo].[DoctorSpeciality] ([id])
GO
ALTER TABLE [dbo].[DiseaseDoctorSpeciality] CHECK CONSTRAINT [FK_DiseaseDoctorSpeciality_DoctorSpeciality]
GO
ALTER TABLE [dbo].[DiseaseDrug]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseDrug_Disease] FOREIGN KEY([disease_id])
REFERENCES [dbo].[Disease] ([id])
GO
ALTER TABLE [dbo].[DiseaseDrug] CHECK CONSTRAINT [FK_DiseaseDrug_Disease]
GO
ALTER TABLE [dbo].[DiseaseDrug]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseDrug_Drug] FOREIGN KEY([drug_id])
REFERENCES [dbo].[Drug] ([id])
GO
ALTER TABLE [dbo].[DiseaseDrug] CHECK CONSTRAINT [FK_DiseaseDrug_Drug]
GO
ALTER TABLE [dbo].[DiseaseSymptom]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseSymptom_Disease] FOREIGN KEY([disease_id])
REFERENCES [dbo].[Disease] ([id])
GO
ALTER TABLE [dbo].[DiseaseSymptom] CHECK CONSTRAINT [FK_DiseaseSymptom_Disease]
GO
ALTER TABLE [dbo].[DiseaseSymptom]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseSymptom_Symptom] FOREIGN KEY([symptom_id])
REFERENCES [dbo].[Symptom] ([id])
GO
ALTER TABLE [dbo].[DiseaseSymptom] CHECK CONSTRAINT [FK_DiseaseSymptom_Symptom]
GO
ALTER TABLE [dbo].[DiseaseTreatment]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseTreatment_Disease] FOREIGN KEY([disease_id])
REFERENCES [dbo].[Disease] ([id])
GO
ALTER TABLE [dbo].[DiseaseTreatment] CHECK CONSTRAINT [FK_DiseaseTreatment_Disease]
GO
ALTER TABLE [dbo].[DiseaseTreatment]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseTreatment_Treatment] FOREIGN KEY([treatment_id])
REFERENCES [dbo].[Treatment] ([id])
GO
ALTER TABLE [dbo].[DiseaseTreatment] CHECK CONSTRAINT [FK_DiseaseTreatment_Treatment]
GO
ALTER TABLE [dbo].[DrugContraindication]  WITH CHECK ADD  CONSTRAINT [FK_DrugContraindication_Contraindication] FOREIGN KEY([contraindication_id])
REFERENCES [dbo].[Contraindication] ([id])
GO
ALTER TABLE [dbo].[DrugContraindication] CHECK CONSTRAINT [FK_DrugContraindication_Contraindication]
GO
ALTER TABLE [dbo].[DrugContraindication]  WITH CHECK ADD  CONSTRAINT [FK_DrugContraindication_Drug] FOREIGN KEY([drug_id])
REFERENCES [dbo].[Drug] ([id])
GO
ALTER TABLE [dbo].[DrugContraindication] CHECK CONSTRAINT [FK_DrugContraindication_Drug]
GO
ALTER TABLE [dbo].[Symptom]  WITH CHECK ADD  CONSTRAINT [FK_Symptom_BodyPart] FOREIGN KEY([bodyPart_id])
REFERENCES [dbo].[BodyPart] ([id])
GO
ALTER TABLE [dbo].[Symptom] CHECK CONSTRAINT [FK_Symptom_BodyPart]
GO
ALTER TABLE [dbo].[SymptomQuestion]  WITH CHECK ADD  CONSTRAINT [FK_SymptomQuestion_Symptom] FOREIGN KEY([symptom_id])
REFERENCES [dbo].[Symptom] ([id])
GO
ALTER TABLE [dbo].[SymptomQuestion] CHECK CONSTRAINT [FK_SymptomQuestion_Symptom]
GO
ALTER TABLE [dbo].[SymptomQuestionAnswer]  WITH CHECK ADD  CONSTRAINT [FK_SymptomQuestionAnswer_SymptomQuestion] FOREIGN KEY([symptomQuestion_id])
REFERENCES [dbo].[SymptomQuestion] ([id])
GO
ALTER TABLE [dbo].[SymptomQuestionAnswer] CHECK CONSTRAINT [FK_SymptomQuestionAnswer_SymptomQuestion]
GO
ALTER TABLE [dbo].[Test]  WITH CHECK ADD  CONSTRAINT [FK_Test_TestType] FOREIGN KEY([testType_id])
REFERENCES [dbo].[TestType] ([id])
GO
ALTER TABLE [dbo].[Test] CHECK CONSTRAINT [FK_Test_TestType]
GO
ALTER TABLE [dbo].[Test]  WITH CHECK ADD  CONSTRAINT [FK_Test_TestUnit] FOREIGN KEY([testUnit_id])
REFERENCES [dbo].[TestUnit] ([id])
GO
ALTER TABLE [dbo].[Test] CHECK CONSTRAINT [FK_Test_TestUnit]
GO
ALTER TABLE [dbo].[UserTest]  WITH CHECK ADD  CONSTRAINT [FK_UserTest_TestFlag] FOREIGN KEY([testFlag_id])
REFERENCES [dbo].[TestFlag] ([id])
GO
ALTER TABLE [dbo].[UserTest] CHECK CONSTRAINT [FK_UserTest_TestFlag]
GO
ALTER TABLE [dbo].[UserTest]  WITH CHECK ADD  CONSTRAINT [FK_UserTest_TestUnit] FOREIGN KEY([testUnit_id])
REFERENCES [dbo].[TestUnit] ([id])
GO
ALTER TABLE [dbo].[UserTest] CHECK CONSTRAINT [FK_UserTest_TestUnit]
GO
ALTER TABLE [dbo].[UserTest]  WITH CHECK ADD  CONSTRAINT [FK_UserTest_User] FOREIGN KEY([user_id])
REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[UserTest] CHECK CONSTRAINT [FK_UserTest_User]
GO
USE [master]
GO
ALTER DATABASE [SelfDiagnosis] SET  READ_WRITE 
GO
