-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2023 a las 10:18:32
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `testjavafx`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id` int(11) NOT NULL,
  `pregunta` text DEFAULT NULL,
  `rutaImagen` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id`, `pregunta`, `rutaImagen`) VALUES
(1, '¿Cuál es tu plan ideal para una noche de fiesta?', 'imagenes/nocheFiesta.jpg'),
(2, '¿Qué canción no puede faltar en una buena fiesta?', 'imagenes/cancionFiesta.jpg'),
(3, '¿Cómo describirías tu personalidad en una palabra?', 'imagenes/palabras.jpg'),
(4, '¿Prefieres algo clásico o innovador?', 'imagenes/cocheClasico.jpg'),
(5, '¿Te gusta tomar riesgos o eres más bien cauteloso/a?', 'imagenes/peligro.png'),
(6, '¿Cuál es tu pasatiempo favorito?', 'imagenes/pasatiempo.jpg'),
(7, '¿Qué prefieres: una noche de baile o una noche de película?', 'imagenes/cine.jpg'),
(8, '¿Qué te gusta hacer en tus días libres?', 'imagenes/correrParque.jpg'),
(9, '¿Cuál es tu comida favorita para acompañar una bebida?', 'imagenes/chuches.jpg'),
(10, '¿Prefieres una bebida dulce o amarga?', 'imagenes/dulce.jpg'),
(11, '¿Cuál es tu bebida favorita?', 'imagenes/bebidasValorar.jpg'),
(12, '¿Eres más de cócteles o de shots?', 'imagenes/chupito.jpg'),
(13, '¿Eres de los que prefiere mezclar varias bebidas en una sola?', 'imagenes/cocktail.jpg'),
(14, '¿Qué tipo de vino te gusta más?', 'imagenes/vino.jpg'),
(15, '¿Cuál es tu lugar favorito para tomar una copa?', 'imagenes/bar.jpg'),
(16, '¿Cuál es tu época del año favorita para tomar una bebida?', 'imagenes/otoño.jpg'),
(17, '¿Qué tipo de música te gusta más?', 'imagenes/musica.jpg'),
(18, '¿Qué te gusta hacer cuando sales a beber con amigos?', 'imagenes/amigos.jpg'),
(19, '¿Prefieres las bebidas alcohólicas con o sin hielo?', 'imagenes/bebidaHielo.jpg'),
(20, '¿Qué es lo que más valoras en una bebida?', 'imagenes/bebidasValorar.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `id` int(11) NOT NULL,
  `opcionA` text DEFAULT NULL,
  `opcionB` text DEFAULT NULL,
  `opcionC` text DEFAULT NULL,
  `opcionD` text DEFAULT NULL,
  `id_pregunta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`id`, `opcionA`, `opcionB`, `opcionC`, `opcionD`, `id_pregunta`) VALUES
(1, 'Ir a una fiesta en casa con música y juegos', 'Tomar cerveza y ver un partido en un bar deportivo', 'Reunirme con amigos en un bar de cócteles y charlar', 'Ir a un club de baile y mover el esqueleto', 1),
(2, '\"Shape of You\" de Ed Sheeran', '\"Livin on a Prayer\" de Bon Jovi', '\"Uptown Funk\" de Mark Ronson y Bruno Mars', '\"I Will Survive\" de Gloria Gaynor', 2),
(3, 'Divertido/a', 'Relajado/a', 'Sofisticado/a', 'Aventurero/a', 3),
(4, 'Me gusta mezclar lo clásico y lo innovador', 'Depende del momento', 'Innovador', 'Clásico', 4),
(5, 'Me gusta encontrar un equilibrio entre ambos', 'Depende de la situación', 'Soy bastante cauteloso/a', 'Me encanta tomar riesgos', 5),
(6, 'Ir a conciertos y festivales', 'Ver películas y series en casa', 'Cocinar y probar nuevos platillos', 'Deportes de aventura', 6),
(7, 'Ambas son buenas opciones', 'Depende del humor', 'Noche de película', 'Noche de baile', 7),
(8, 'Planear una actividad divertida con amigos', 'Descansar en casa', 'Leer un buen libro en un café', 'Salir a explorar la ciudad', 8),
(9, 'Sushi', 'Patatas fritas', 'Quesos finos', 'Alitas de pollo', 9),
(10, 'Me gustan ambas', 'Depende del día', 'Amarga', 'Dulce', 10),
(11, 'Cubata', 'Cerveza', 'Martini', 'Margarita', 11),
(12, 'Me gustan ambos', 'Depende de la ocasión', 'Shots', 'Cócteles', 12),
(13, 'A veces sí, a veces no', 'Depende de la ocasión y la compañía', 'No, prefiero mantenerlo simple', 'Sí, me gusta probar nuevas combinaciones', 13),
(14, 'No me gusta el vino', 'Rosado', 'Blanco', 'Tinto', 14),
(15, 'No me gusta beber, soy sano', 'De fiesta', 'Un bar', 'Una terraza', 15),
(16, 'Otoño', 'Primavera', 'Invierno', 'Verano', 16),
(17, 'Electrónica', 'Reggaetón', 'Rock', 'Pop', 17),
(18, 'Ninguna de las anteriores', 'Jugar juegos de mesa o de cartas', 'Estar tranquilito', 'Bailar toda la noche', 18),
(19, 'No bebo', 'Me da igual', 'Sin', 'Con', 19),
(20, 'Experiencia en general', 'Precio', 'Calidad', 'Sabor', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

CREATE TABLE `resultados` (
  `id` int(11) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `rutaImagen` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `resultados`
--

INSERT INTO `resultados` (`id`, `descripcion`, `nombre`, `rutaImagen`) VALUES
(1, 'Eres una persona tranquila y sana que no bebe', 'Actimel', 'imagenes/actimel.jpg'),
(2, 'Eres una persona tranquila que le gusta bebe de vez en cuando', 'Vermú', 'imagenes/vermu.jpg'),
(3, 'Eres una persona que bebe poco, pero es de bebidas intensas cuando sale', 'Vino', 'imagenes/vinoResul.jpg'),
(4, 'Te gusta beber de vez en cuando, pero no cosas muy fuertes. Tipical spanish', 'Cerveza', 'imagenes/cerveza.jpg'),
(5, 'Eres una persona que le gusta beber poco pero un poco mas fuerte', 'Chupito', 'imagenes/chupitoResul.jpg'),
(6, 'Eres una persona que le gusta beber bastante y fuerte', 'Jagger', 'imagenes/jagger.jpg'),
(7, 'Probablemente eres un pirata', 'Ron', 'imagenes/ron.jpg'),
(8, 'Probablemente eres ruso', 'Vodka', 'imagenes/vodka.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pregunta` (`id_pregunta`);

--
-- Indices de la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `resultados`
--
ALTER TABLE `resultados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`id_pregunta`) REFERENCES `preguntas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
