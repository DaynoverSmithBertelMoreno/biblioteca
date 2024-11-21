-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2024 at 12:32 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ilib`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` varchar(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `edit` varchar(255) NOT NULL,
  `lang` varchar(255) NOT NULL,
  `pages` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `ejemplares` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `available` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `title`, `date`, `author`, `category`, `edit`, `lang`, `pages`, `description`, `ejemplares`, `stock`, `available`) VALUES
('978-607-07-3696-9', 'Pedro Páramo', '1955-03-19', 'Juan Rulfo', 'Novela', '1ra Edición', 'Español', '124', 'Una historia de realismo mágico en Comala.', '5', 5, 1),
('978-607-31-8058-5', 'Como Agua Para Chocolate', '1989-09-01', 'Laura Esquivel', 'Novela', '1ra Edición', 'Español', '256', 'Una historia de amor y gastronomía mexicana.', '8', 8, 1),
('978-607-31-8074-5', 'El Alquimista', '1988-04-25', 'Paulo Coelho', 'Novela', '2da Edición', 'Español', '208', 'Un viaje de autodescubrimiento.', '8', 8, 1),
('978-84-204-8243-6', 'Don Quijote de la Mancha', '1605-01-16', 'Miguel de Cervantes', 'Clásico', 'Edición Completa', 'Español', '1344', 'La novela más destacada de la literatura española.', '12', 12, 1),
('978-84-376-0494-7', 'La Casa de los Espíritus', '1982-10-12', 'Isabel Allende', 'Novela', '1ra Edición', 'Español', '368', 'Una saga familiar en el contexto del realismo mágico.', '7', 7, 1),
('978-84-663-3242-0', 'El Amor en los Tiempos del Cólera', '1985-10-15', 'Gabriel García Márquez', 'Novela', '2da Edición', 'Español', '464', 'Una historia de amor que desafía el tiempo.', '9', 9, 1),
('978-84-663-5047-9', 'La Sombra del Viento', '2001-06-01', 'Carlos Ruiz Zafón', 'Novela', '5ta Edición', 'Español', '576', 'Misterio en la Barcelona de posguerra.', '6', 6, 1),
('978-84-670-3989-2', 'Cien Años de Soledad', '1967-05-30', 'Gabriel García Márquez', 'Novela', '1ra Edición', 'Español', '417', 'Una de las obras más importantes de la literatura latinoamericana.', '10', 10, 1),
('978-950-07-1879-1', 'Ficciones', '1944-09-10', 'Jorge Luis Borges', 'Cuentos', '4ta Edición', 'Español', '200', 'Relatos que exploran la realidad y el universo.', '5', 5, 1),
('978-950-54-7097-7', 'Rayuela', '1963-06-28', 'Julio Cortázar', 'Novela', '3ra Edición', 'Español', '736', 'Una novela experimental que invita a un juego de lectura.', '7', 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `lendings`
--

CREATE TABLE `lendings` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `book_id` varchar(255) NOT NULL,
  `date_out` varchar(255) NOT NULL,
  `date_return` varchar(255) DEFAULT NULL,
  `date_limit` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `last_name_p` varchar(30) NOT NULL,
  `last_name_m` varchar(30) NOT NULL,
  `domicilio` varchar(250) DEFAULT NULL,
  `tel` varchar(25) DEFAULT NULL,
  `sanctions` int(11) DEFAULT 0,
  `sanc_money` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `last_name_p`, `last_name_m`, `domicilio`, `tel`, `sanctions`, `sanc_money`) VALUES
(1001234567, 'Juan', 'Pérez', 'García', 'Calle 1 #123', '3214567890', 0, 0),
(1002345678, 'María', 'López', 'Martínez', 'Calle 2 #234', '3123456789', 0, 0),
(1003456789, 'Carlos', 'Hernández', 'Jiménez', 'Calle 3 #345', '3001234567', 0, 0),
(1004567890, 'Ana', 'Gómez', 'Morales', 'Calle 4 #456', '3102345678', 0, 0),
(1005678901, 'Luis', 'Díaz', 'Ortega', 'Calle 5 #567', '3113456789', 0, 0),
(1006789012, 'Jorge', 'Rodríguez', 'Santos', 'Calle 6 #678', '3124567890', 0, 0),
(1007890123, 'Laura', 'Mendoza', 'Ríos', 'Calle 7 #789', '3135678901', 0, 0),
(1008901234, 'Sofía', 'Romero', 'Sánchez', 'Calle 8 #890', '3146789012', 0, 0),
(1009012345, 'Diego', 'Fernández', 'Ramírez', 'Calle 9 #901', '3157890123', 0, 0),
(1010123456, 'Daniela', 'Silva', 'Flores', 'Calle 10 #012', '3168901234', 0, 0),
(1011234567, 'Miguel', 'Cruz', 'Pérez', 'Calle 11 #123', '3179012345', 0, 0),
(1012345678, 'Valentina', 'Castro', 'Gómez', 'Calle 12 #234', '3180123456', 0, 0),
(1013456789, 'Santiago', 'Gutiérrez', 'Cano', 'Calle 13 #345', '3191234567', 0, 0),
(1014567890, 'Carolina', 'Ramos', 'López', 'Calle 14 #456', '3202345678', 0, 0),
(1015678901, 'David', 'Vargas', 'Jiménez', 'Calle 15 #567', '3213456789', 0, 0),
(1016789012, 'Andrea', 'Moreno', 'Salazar', 'Calle 16 #678', '3224567890', 0, 0),
(1017890123, 'Camila', 'Pardo', 'Suárez', 'Calle 17 #789', '3235678901', 0, 0),
(1018901234, 'Andrés', 'Fuentes', 'Ríos', 'Calle 18 #890', '3246789012', 0, 0),
(1019012345, 'Natalia', 'Peña', 'Molina', 'Calle 19 #901', '3257890123', 0, 0),
(1020123456, 'Manuel', 'Ríos', 'Vega', 'Calle 20 #012', '3268901234', 0, 0),
(1021234567, 'Paola', 'Vargas', 'Rojas', 'Calle 21 #123', '3279012345', 0, 0),
(1022345678, 'Felipe', 'García', 'Reyes', 'Calle 22 #234', '3280123456', 0, 0),
(1023456789, 'Marta', 'Ramírez', 'Aguilar', 'Calle 23 #345', '3291234567', 0, 0),
(1024567890, 'Sergio', 'Torres', 'Pineda', 'Calle 24 #456', '3302345678', 0, 0),
(1025678901, 'Raúl', 'Romero', 'González', 'Calle 25 #567', '3313456789', 0, 0),
(1026789012, 'Lucía', 'Muñoz', 'Álvarez', 'Calle 26 #678', '3324567890', 0, 0),
(1027890123, 'Pedro', 'Santos', 'Montoya', 'Calle 27 #789', '3335678901', 0, 0),
(1028901234, 'Juliana', 'Suárez', 'Nieto', 'Calle 28 #890', '3346789012', 0, 0),
(1029012345, 'Nicolás', 'Rojas', 'Castillo', 'Calle 29 #901', '3357890123', 0, 0),
(1030123456, 'Isabella', 'Ruiz', 'Moreno', 'Calle 30 #012', '3368901234', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `password`) VALUES
(2, '1', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lendings`
--
ALTER TABLE `lendings`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lendings`
--
ALTER TABLE `lendings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2147483648;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
