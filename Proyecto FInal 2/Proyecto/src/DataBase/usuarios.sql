--
-- Table structure for table `usuarios`
--

CREATE DATABASE IF NOT EXISTS `juego`;
USE `juego`;

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `user` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nivel` varchar(100) NOT NULL,
  PRIMARY KEY (`idusuario`)
);

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuarios` WRITE;
INSERT INTO `usuarios` VALUES (1,'pablo','123','admin'),(2,'jared','123','jugador'),(3,'alan','123','jugador');
UNLOCK TABLES;
