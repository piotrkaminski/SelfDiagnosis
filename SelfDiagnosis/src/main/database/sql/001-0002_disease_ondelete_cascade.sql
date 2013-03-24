ALTER TABLE [dbo].[DiseaseSymptom] DROP CONSTRAINT [FK_DiseaseSymptom_Disease]
GO

ALTER TABLE [dbo].[DiseaseSymptom]  WITH CHECK ADD  CONSTRAINT [FK_DiseaseSymptom_Disease] FOREIGN KEY([disease_id])
REFERENCES [dbo].[Disease] ([id])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[DiseaseSymptom] CHECK CONSTRAINT [FK_DiseaseSymptom_Disease]
GO
