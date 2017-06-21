CREATE DATABASE `OrganMarket` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `OrganMarket`;

CREATE TABLE `Stock` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Organ` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `Donator` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Stock` (`Organ`, `Price`, `Donator`) VALUES
('Pair of Eyes', '873.69', '47 years old, non-smoker, no drugs, no diseases'),
('Scalp', '347.71', '26 years old, non-smoker, no drugs, no diseases'),
('Liver', '89974.58', '40 years old, non-smoker, no drugs, diabetes'),
('Kidney', '150123.63', '15 years old, non-smoker, no drugs, no diseases'),
('Coronary Artery', '873.81', '50 years old, smoker, no drugs, arterial hypertension'),
('Skin (Inch)', '3.03', '34 years old, smoker, drugs, vitiligo'),
('Hand and Forearm', '118.43', '57 years old, non-smoker, no drugs, no diseases'),
('Heart', '68185.92', '19 years old, non-smoker, drugs, no diseases'),
('Liter of Blood', '193.09', '16 years old, non-smoker, no drugs, bronchial asthma'),
('Gallbladder', '698.47', '26 years old, smoker, drugs, obesity'),
('Skull with Teeth', '687.58', '39 years old, smoker, drugs, cirrhosis'),
('Small Intestine', '1443.36', '23 years old, non-smoker, no drugs, '),
('Spleen', '291.07', '27 years old, non-smoker, no drugs, psychiatric condition'),
('Shoulders', '286.49', '26 years old, smoker, no drugs, no diseases'),
('Stomach', '291.07', '44 years old, non-smoker, no drugs, obesity');