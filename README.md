# Análisis del Sistema

## Objetivo General:
Desarrollar un sistema para gestionar el préstamo de libros en una biblioteca, que permita a los usuarios buscar, solicitar y devolver libros, así como a los administradores gestionar los libros y los préstamos.

## Componentes Principales:

- Usuarios: Personas que usan el sistema para buscar libros, solicitar préstamos y devolver libros.
- Libros: Elementos que se prestan y devuelven en el sistema.
- Préstamos: Transacciones que registran qué libro ha sido prestado a qué usuario y por cuánto tiempo.


# Prerequisitos

## Software:

- Java Development Kit (JDK): Para desarrollar el sistema en Java.
- IDE: NetBeans.
- Sistema de Gestión de Bases de Datos:MySQL.

---
# Objetivos del Sistema

### Gestión de Libros:

- Añadir, editar y eliminar libros.
- Consultar el estado de los libros (disponible, prestado).

### Gestión de Usuarios:

- Añadir, editar y eliminar usuarios.
- Consultar información sobre usuarios y sus préstamos.
### Préstamos y Devoluciones:

- Registrar el préstamo de un libro a un usuario.
- Registrar la devolución de un libro.
- Calcular y gestionar los retrasos y las multas asociadas.
### Búsqueda y Consulta:

- Permitir la búsqueda de libros por diferentes criterios (título, autor, género, etc.).
- Consultar el historial de préstamos de un libro o de un usuario.

### Interfaz de Usuario:

- Proveer una interfaz amigable para que tanto usuarios como administradores interactúen con el sistema.



---

# Funcionalidad del Software

## Usuarios:

### Registro e Inicio de Sesión:

- Los usuarios deben poder registrarse e iniciar sesión para poder solicitar préstamos.
### Buscar Libros:

- Permitir a los usuarios buscar libros por título.
### Solicitar Préstamo:

- Permitir a los usuarios solicitar el préstamo de un libro disponible.
### Devolver Libros:

- Permitir a los usuarios devolver libros prestados.

## Administradores:

### Gestión de Libros:

- Añadir nuevos libros, actualizar información de libros existentes y eliminar libros.
### Gestión de Usuarios:


- Añadir nuevos usuarios, actualizar información de usuarios existentes y eliminar usuarios.
### Gestión de Préstamos:

- Registrar préstamos y devoluciones de libros.

### Control de Multas:

- Calcular y gestionar multas por retrasos en la devolución de libros.
## Para el Sistema en General:

### Persistencia de Datos:

- Toda la información relevante (libros, usuarios, préstamos) se guarda y recupera de manera eficiente gracias a mysql.

### Interfaz Gráfica:

- El sistema tendrá una interfaz gráfica usando Swing.