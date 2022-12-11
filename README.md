# Reserva La Pista

#### Curso Escolar 2022-2023
#### Autor: Sebastián Bermúdez Herrera (https://github.com/sebasbermuher)
#### Tutor: Antonio Gabriel González Casado
#### Fecha de Inicio: 15-09-2022
#### Fecha de Finalización: 13-12-2022

## Breve descripción del proyecto

**ReservaLaPista** es una aplicación web donde podrás reservar pistas deportivas.

Normalmente, cuando quieres reservar una pista, por ejemplo en tu polideportivo municipal, debes de llamar o presentarte en la oficina. Esta aplicación está pensada para que desde tu casa y sin tener que contactar con nadie lo puedas hacer en un simple click, sin depender de nadie, solamente con internet.

Y es que, cada vez, el uso de estas tecnologías son más frecuentes y son de gran ayuda para las personas.

Cuenta con varias funciones, pero la principal es la de reservar espacios.

¿Por que no te atreves y la usas?

## Definir el objetivo de la aplicación
El propósito de esta aplicación es poder facilitarle a las personas el poder alquilar pistas deportivas, sin tener que hacer ninguna gestión extra. 

Mediante esta aplicación conectamos a los usuarios directamente a nuestra base de datos, en la que ellos mismos pueden ver la disponibilidad horaria de cada espacio deportivo.

Es una web muy intuitiva y clara, fácil de usar para todas la edades, sin necesidad de tener conocimiento avanzados de infomática.

A parte de ayudar a los usuarios a la gestión de reservas, también es de gran ayuda para la empresa puesto que no tendría que depender de una persona encargada de realizar las reservas manualmente.

Algunos de los requisitos funcionales son:

- **REQ01-Login**: El usuario deberá loguearse con su cuenta para poder entrar. Si no tiene cuenta podrá crearse una en el formulario de crear cuenta.
- **REQ02-Alta de usuario**: El usuario sin cuenta registrada podrá crearse una cuente nueva.
- **REQ03-Baja de usuario**: El usuario puede darse de baja cuando desee y su cuente será eliminada.
- **REQ04-Reserva de espacios**: El usuario puede ver la disponibilidad de las pistas y realizar reservas.
- **REQ05-Mis reservas**: El sistema deberá mostrar las reservas realizada por el usuario.
- **REQ06-Ajustes de usuario**: El sistema cuenta con un apartado de ajustes para que el usuario modifique sus datos.
- **REQ07-Logout**: El sistema cuenta con un boton logout en la barra superior, para que el usuario puede cerra sesión cuando quiera.
- **REQ08-Eliminar reserva**: El sistema tiene un apartado para cancelar la reserva.
- **REQ09-Pistas**: En este apartado el usuario puede ver las pistas que hay y sus datos, como por ejemplo el horario.

## Stack Tecnológico

Para la parte back he decidido escoger **Eclipse**, ya que es el que vengo usando y con el que me encuentro más comodo.
En cuanto a la parte del front usaré **Visual Studio Code**, fácil de usar y con variedad de plugins.

El framework que usaré será **Spring**, ya que podemos usar **Tomcat** y cuenta con muchas dependencias. Algunas de las dependencias que usaré son:
- **Spring Boot**: Facilita la creación de aplicaciones Spring y contiene Tomcat
- **Spring web**: ensecial para un web, con patron MVC.
- **Spring web**: ensecial para un web, con patron MVC.
- **Spring DATA JPA** y **MariaDB**: para controlar los datos de almacenamiento SQL usando Hibernate.
- **Spring security**: cuenta con autenticación. Puede crear filtro para diferenciar a que pagina puede ir el usuario dependiendo por ejemplo del rol que tenga. Tambien tiene encriptación de contraseñas.
- Tengo una dependecia extra pensada (investigar) que me servirá para enviar email al usuario para confirmar la reserva.

Para la vista MVC, usaré **Thymeleaf**.

Para la parte frontend utilizaré principalmente **HTML5** y **CSS3**, añadiendo **Bootstrap**, ya que me ayudará a hacer mi web responsive.
Tambien implementaré **Javascript** para que la web sea más interactiva.

Para la gestión de la base de datos usare **MariaDB** (SQL) en un contenedor **Docker**. En la parte local me ayudaré con **DBeaver**, que es una interfaz para la gestión de bases de datos.


## Prototipo de la Interfaz del proyecto

En este apartado el alumno insertará la documentación del prototipo del proyecto (sketch, wireframe, mockup y un prototipo HTML y CSS)  que permite al cliente previsualizar el resultado final del producto que se está desarrollando.

....
....
....

## Estructura del Proyecto

En este apartado el alumno explicará el contenido del repositorio y de todas las carpetas relevantes del mismo.

## Demostración del proyecto

Vídeo demostrativo que contenga una pequeña demostración de la apariencia del proyecto y de aquello que el proyecto puede hacer. (No más de 2 minutos).
