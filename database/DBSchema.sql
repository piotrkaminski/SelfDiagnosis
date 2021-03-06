USE [master]
GO
/****** Object:  Database [SelfDiagnosis]    Script Date: 2013-02-09 13:35:56 ******/
CREATE DATABASE [SelfDiagnosis]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SelfDiagnosis', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.DEV\MSSQL\DATA\SelfDiagnosis_1.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'SelfDiagnosis_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.DEV\MSSQL\DATA\SelfDiagnosis_1_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
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
/****** Object:  User [selfdiagnosis]    Script Date: 2013-02-09 13:35:56 ******/
CREATE USER [selfdiagnosis] FOR LOGIN [selfdiagnosis] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [selfdiagnosis]
GO
/****** Object:  Table [dbo].[AgeRange]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AgeRange](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[yearsFrom] [int] NULL,
	[yearsTo] [int] NULL,
 CONSTRAINT [PK_AgeRange] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BodyPart]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BodyPart](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[parentBodyPart_id] [int] NULL,
 CONSTRAINT [PK_BodyPart] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Contraindication]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contraindication](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](max) NULL,
 CONSTRAINT [PK_Contraindication] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Disease]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Disease](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[description] [nvarchar](max) NULL,
	[frequency] [smallint] NOT NULL,
 CONSTRAINT [PK_Disease] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DiseaseDoctorSpecialty]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiseaseDoctorSpecialty](
	[disease_id] [numeric](19, 0) NOT NULL,
	[doctorSpecialty_id] [int] NOT NULL,
 CONSTRAINT [PK_DiseaseDoctorSpecialty] PRIMARY KEY CLUSTERED 
(
	[disease_id] ASC,
	[doctorSpecialty_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DiseaseSymptom]    Script Date: 2013-02-09 13:35:57 ******/
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
/****** Object:  Table [dbo].[DiseaseSymptomSymptomQuestionAnswer]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiseaseSymptomSymptomQuestionAnswer](
	[diseaseSymptom_id] [numeric](19, 0) NOT NULL,
	[symptomQuestionAnswer_id] [numeric](19, 0) NOT NULL,
	[rankModifier] [int] NOT NULL,
 CONSTRAINT [PK_DiseaseSymptomSymptomQuestionAnswer] PRIMARY KEY CLUSTERED 
(
	[diseaseSymptom_id] ASC,
	[symptomQuestionAnswer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DiseaseTreatment]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiseaseTreatment](
	[disease_id] [numeric](19, 0) NOT NULL,
	[treatment_id] [numeric](19, 0) NOT NULL,
 CONSTRAINT [PK_DiseaseTreatment] PRIMARY KEY CLUSTERED 
(
	[disease_id] ASC,
	[treatment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DoctorSpecialty]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DoctorSpecialty](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](max) NULL,
 CONSTRAINT [PK_DoctorSpecialty] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Drug]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Drug](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[description] [nvarchar](max) NULL,
 CONSTRAINT [PK_Drug] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DrugContraindication]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DrugContraindication](
	[drug_id] [numeric](19, 0) NOT NULL,
	[contraindication_id] [numeric](19, 0) NOT NULL,
 CONSTRAINT [PK_DrugContraindication] PRIMARY KEY CLUSTERED 
(
	[drug_id] ASC,
	[contraindication_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Gender]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gender](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](20) NOT NULL,
	[shortName] [nvarchar](1) NOT NULL,
 CONSTRAINT [PK_Gender] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Recommendation]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recommendation](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[recommendation] [nvarchar](1000) NOT NULL,
 CONSTRAINT [PK_Recommendation] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Symptom]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Symptom](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[description] [nvarchar](max) NULL,
	[symptomType_id] [int] NOT NULL,
	[bodyPart_id] [int] NULL,
	[test_id] [numeric](19, 0) NULL,
 CONSTRAINT [PK_Symptom] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SymptomQuestion]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SymptomQuestion](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[symptom_id] [numeric](19, 0) NOT NULL,
	[questionNumber] [smallint] NOT NULL,
	[question] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_SymptomQuestion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SymptomQuestionAnswer]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SymptomQuestionAnswer](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[symptomQuestion_id] [numeric](19, 0) NOT NULL,
	[answerNumber] [smallint] NOT NULL,
	[answer] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_SymptomQuestionAnswer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SymptomType]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SymptomType](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](max) NULL,
 CONSTRAINT [PK_SymptomType] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Test]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Test](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[description] [nvarchar](max) NULL,
	[testType_id] [int] NOT NULL,
	[validForDays] [int] NULL,
 CONSTRAINT [PK_Test] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestBaseResult]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestBaseResult](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[test_id] [numeric](19, 0) NOT NULL,
	[ageRange_id] [numeric](19, 0) NULL,
	[gender_id] [int] NULL,
	[minimumValue] [numeric](18, 4) NULL,
	[maximumValue] [numeric](18, 4) NULL,
	[testUnit_id] [int] NULL,
 CONSTRAINT [PK_TestBaseResult] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestFlag]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestFlag](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](20) NOT NULL,
	[description] [nvarchar](100) NULL,
 CONSTRAINT [PK_TestFlag] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestRecommendation]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestRecommendation](
	[test_id] [numeric](19, 0) NOT NULL,
	[recommendation_id] [numeric](19, 0) NOT NULL,
	[parameter] [nvarchar](10) NULL,
 CONSTRAINT [PK_TestRecommendation] PRIMARY KEY CLUSTERED 
(
	[test_id] ASC,
	[recommendation_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestType]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestType](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[description] [nvarchar](max) NULL,
 CONSTRAINT [PK_TestType] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestTypeRecommendation]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestTypeRecommendation](
	[testType_id] [int] NOT NULL,
	[recommendation_id] [numeric](19, 0) NOT NULL,
	[parameter] [nvarchar](10) NULL,
 CONSTRAINT [PK_TestTypeRecommendation] PRIMARY KEY CLUSTERED 
(
	[testType_id] ASC,
	[recommendation_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestUnit]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestUnit](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[shortName] [nvarchar](10) NULL,
 CONSTRAINT [PK_TestUnit] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Treatment]    Script Date: 2013-02-09 13:35:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Treatment](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[description] [nvarchar](max) NULL,
	[treatmentType_id] [int] NOT NULL,
	[drug_id] [numeric](19, 0) NULL,
 CONSTRAINT [PK_Treatment] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TreatmentType]    Script Date: 2013-02-09 13:35:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TreatmentType](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[description] [nvarchar](max) NULL,
 CONSTRAINT [PK_TreatmentType] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 2013-02-09 13:35:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[firstName] [nvarchar](50) NULL,
	[lastName] [nvarchar](50) NULL,
	[email] [nvarchar](100) NULL,
	[tel] [nvarchar](30) NULL,
	[zipCode] [nvarchar](10) NULL,
	[city] [nvarchar](50) NULL,
	[address] [nvarchar](50) NULL,
	[signInDate] [datetime] NULL,
	[lastLogIn] [datetime] NULL,
	[password] [nvarchar](50) NULL,
	[ip] [nvarchar](30) NULL,
	[gender] [nvarchar](1) NULL,
	[birthDate] [date] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserTest]    Script Date: 2013-02-09 13:35:58 ******/
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
ALTER TABLE [dbo].[BodyPart]  WITH CHECK ADD  CONSTRAINT [FK_BodyPart_BodyPart] FOREIGN KEY([parentBodyPart_id])
REFERENCES [dbo].[BodyPart] ([id])
GO
ALTER TABLE [dbo].[BodyPart] CHECK CONSTRAINT [FK_BodyPart_BodyPart]
GO
ALTER TABLE [dbo].[DiseaseDoctorSpecialty]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseDoctorSpecialty_Disease] FOREIGN KEY([disease_id])
REFERENCES [dbo].[Disease] ([id])
GO
ALTER TABLE [dbo].[DiseaseDoctorSpecialty] CHECK CONSTRAINT [FK_DiseaseDoctorSpecialty_Disease]
GO
ALTER TABLE [dbo].[DiseaseDoctorSpecialty]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseDoctorSpecialty_DoctorSpecialty] FOREIGN KEY([doctorSpecialty_id])
REFERENCES [dbo].[DoctorSpecialty] ([id])
GO
ALTER TABLE [dbo].[DiseaseDoctorSpecialty] CHECK CONSTRAINT [FK_DiseaseDoctorSpecialty_DoctorSpecialty]
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
ALTER TABLE [dbo].[DiseaseSymptomSymptomQuestionAnswer]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseSymptomSymptomQuestionAnswer_DiseaseSymptom] FOREIGN KEY([diseaseSymptom_id])
REFERENCES [dbo].[DiseaseSymptom] ([id])
GO
ALTER TABLE [dbo].[DiseaseSymptomSymptomQuestionAnswer] CHECK CONSTRAINT [FK_DiseaseSymptomSymptomQuestionAnswer_DiseaseSymptom]
GO
ALTER TABLE [dbo].[DiseaseSymptomSymptomQuestionAnswer]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseSymptomSymptomQuestionAnswer_SymptomQuestionAnswer] FOREIGN KEY([symptomQuestionAnswer_id])
REFERENCES [dbo].[SymptomQuestionAnswer] ([id])
GO
ALTER TABLE [dbo].[DiseaseSymptomSymptomQuestionAnswer] CHECK CONSTRAINT [FK_DiseaseSymptomSymptomQuestionAnswer_SymptomQuestionAnswer]
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
ALTER TABLE [dbo].[Symptom]  WITH CHECK ADD  CONSTRAINT [FK_Symptom_SymptomType] FOREIGN KEY([symptomType_id])
REFERENCES [dbo].[SymptomType] ([id])
GO
ALTER TABLE [dbo].[Symptom] CHECK CONSTRAINT [FK_Symptom_SymptomType]
GO
ALTER TABLE [dbo].[Symptom]  WITH CHECK ADD  CONSTRAINT [FK_Symptom_Test] FOREIGN KEY([test_id])
REFERENCES [dbo].[Test] ([id])
GO
ALTER TABLE [dbo].[Symptom] CHECK CONSTRAINT [FK_Symptom_Test]
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
ALTER TABLE [dbo].[TestBaseResult]  WITH CHECK ADD  CONSTRAINT [FK_TestBaseResult_AgeRange] FOREIGN KEY([ageRange_id])
REFERENCES [dbo].[AgeRange] ([id])
GO
ALTER TABLE [dbo].[TestBaseResult] CHECK CONSTRAINT [FK_TestBaseResult_AgeRange]
GO
ALTER TABLE [dbo].[TestBaseResult]  WITH CHECK ADD  CONSTRAINT [FK_TestBaseResult_Gender] FOREIGN KEY([gender_id])
REFERENCES [dbo].[Gender] ([id])
GO
ALTER TABLE [dbo].[TestBaseResult] CHECK CONSTRAINT [FK_TestBaseResult_Gender]
GO
ALTER TABLE [dbo].[TestBaseResult]  WITH CHECK ADD  CONSTRAINT [FK_TestBaseResult_Test] FOREIGN KEY([test_id])
REFERENCES [dbo].[Test] ([id])
GO
ALTER TABLE [dbo].[TestBaseResult] CHECK CONSTRAINT [FK_TestBaseResult_Test]
GO
ALTER TABLE [dbo].[TestBaseResult]  WITH CHECK ADD  CONSTRAINT [FK_TestBaseResult_TestUnit] FOREIGN KEY([testUnit_id])
REFERENCES [dbo].[TestUnit] ([id])
GO
ALTER TABLE [dbo].[TestBaseResult] CHECK CONSTRAINT [FK_TestBaseResult_TestUnit]
GO
ALTER TABLE [dbo].[TestRecommendation]  WITH CHECK ADD  CONSTRAINT [FK_TestRecommendation_Recommendation] FOREIGN KEY([recommendation_id])
REFERENCES [dbo].[Recommendation] ([id])
GO
ALTER TABLE [dbo].[TestRecommendation] CHECK CONSTRAINT [FK_TestRecommendation_Recommendation]
GO
ALTER TABLE [dbo].[TestRecommendation]  WITH CHECK ADD  CONSTRAINT [FK_TestRecommendation_Test] FOREIGN KEY([test_id])
REFERENCES [dbo].[Test] ([id])
GO
ALTER TABLE [dbo].[TestRecommendation] CHECK CONSTRAINT [FK_TestRecommendation_Test]
GO
ALTER TABLE [dbo].[TestTypeRecommendation]  WITH CHECK ADD  CONSTRAINT [FK_TestTypeRecommendation_Recommendation] FOREIGN KEY([recommendation_id])
REFERENCES [dbo].[Recommendation] ([id])
GO
ALTER TABLE [dbo].[TestTypeRecommendation] CHECK CONSTRAINT [FK_TestTypeRecommendation_Recommendation]
GO
ALTER TABLE [dbo].[TestTypeRecommendation]  WITH CHECK ADD  CONSTRAINT [FK_TestTypeRecommendation_TestType] FOREIGN KEY([testType_id])
REFERENCES [dbo].[TestType] ([id])
GO
ALTER TABLE [dbo].[TestTypeRecommendation] CHECK CONSTRAINT [FK_TestTypeRecommendation_TestType]
GO
ALTER TABLE [dbo].[Treatment]  WITH CHECK ADD  CONSTRAINT [FK_Treatment_Drug] FOREIGN KEY([drug_id])
REFERENCES [dbo].[Drug] ([id])
GO
ALTER TABLE [dbo].[Treatment] CHECK CONSTRAINT [FK_Treatment_Drug]
GO
ALTER TABLE [dbo].[Treatment]  WITH CHECK ADD  CONSTRAINT [FK_Treatment_TreatmentType] FOREIGN KEY([treatmentType_id])
REFERENCES [dbo].[TreatmentType] ([id])
GO
ALTER TABLE [dbo].[Treatment] CHECK CONSTRAINT [FK_Treatment_TreatmentType]
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
ALTER TABLE [dbo].[UserTest]  WITH CHECK ADD  CONSTRAINT [FKF3F82B1D365DD8AF] FOREIGN KEY([test_id])
REFERENCES [dbo].[Test] ([id])
GO
ALTER TABLE [dbo].[UserTest] CHECK CONSTRAINT [FKF3F82B1D365DD8AF]
GO
USE [master]
GO
ALTER DATABASE [SelfDiagnosis] SET  READ_WRITE 
GO
