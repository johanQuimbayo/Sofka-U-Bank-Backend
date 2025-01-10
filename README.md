
# Documentación Técnica del Proyecto: Sofka-U-Bank-Backend

## **Descripción del Proyecto**
El sistema bancario permite manejar usuarios, cuentas bancarias y transacciones financieras básicas, como depósitos y retiros.
---

## **Tecnologías Utilizadas**
- **Lenguaje de Programación:** Java 21
- **Framework:** Spring Boot
- **Base de Datos:** H2 Database
- **Control de Versiones:** Git (repositorio alojado en GitHub)
- **Metodologia de Git:** Trunk-base
- **Pruebas:** JUnit y Mockito

---

## **Estructura del Proyecto**

### **Paquetes**

1. **`commons`**: Contiene clases DTO de entrada y utilizadas en distintas capas del proyecto.

2. **`config`**: Clases relacionadas con la configuración del sistema.
   - Configuración de Spring Security.
   - Configuración de JWT.

3. **`controllers`**: Controladores que manejan las solicitudes HTTP.
   - **`UserController`**: Endpoints para la gestión de usuarios.
   - **`AccountController`**: Endpoints para la gestión de cuentas bancarias.
   - **`TransactionController`**: Endpoints para operaciones de depósito y retiro.

4. **`data`**: Contiene las entidades JPA y los repositorios.
   - **Entidades:** Representan las tablas de la base de datos (`User`, `Account`, `Transaction`).
   - **Repositorios:** Interfaces para interactuar con la base de datos mediante Spring Data JPA.

5. **`exceptions`**: Manejo centralizado de errores.
   - Clases personalizadas para excepciones como `NotFoundException` o `AlreadyExistException`.
   - Controlador global de excepciones para retornar respuestas HTTP significativas.

6. **`mappers`**: Conversores de entidades a DTOs y viceversa.
   - Facilita la comunicación entre las entidades y los datos enviados o recibidos por el cliente.

7. **`services`**: Implementa la lógica de negocio.
   - **`UserService`**: Manejo de la creación, actualización y eliminación de usuarios.
   - **`AccountService`**: Creación y consulta de cuentas bancarias.
   - **`TransactionService`**: Depósitos, retiros y registro de transacciones.

8. **Archivo `AccountApplication`**: Clase principal que inicializa la aplicación Spring Boot.

9. **`resources`**:
   - **`application.yaml`**: Configuración de la base de datos H2 y otros ajustes globales.

---

## **Modelo de Base de Datos**

### **Entidades**

1. **`User`**:
   - **Atributos:**
     - `id`: Clave primaria.
     - `firstName`, `lastName`: Nombres del usuario.
     - `email`: Único para cada usuario.
     - `password`: Contraseña almacenada de forma segura (hashed).
   - **Relaciones:**
     - Uno a muchos con `Account`.

2. **`Account`**:
   - **Atributos:**
     - `id`: Clave primaria.
     - `accountNumber`: Número de cuenta único.
     - `balance`: Saldo actual.
     - `type`: Tipo de cuenta (ahorros, corriente).
   - **Relaciones:**
     - Muchos a uno con `User`.
     - Uno a muchos con `Transaction`.

3. **`Transaction`**:
   - **Atributos:**
     - `id`: Clave primaria.
     - `accountNumber`: Número de cuenta asociada.
     - `amount`: Monto de la transacción.
     - `isSuccessful`: Indica si la transacción fue exitosa.
   - **Relaciones:**
     - Muchos a uno con `Account`.
    

    <img width="542" alt="image" src="https://github.com/user-attachments/assets/88601f6d-32a1-4e60-b86c-533204cd33d8" />


---

## **Endpoints REST**

### **Usuarios (`/api/users`):**
- **get:** consultar usuario por id y consultar todos los usuarios.
- **PUT:** Actualizar información del usuario.
- **DELETE:** Eliminar usuario.

### **Cuentas Bancarias (`/api/accounts`):**
- **POST:** Crear cuenta.
- **GET:** Consultar saldo de una cuenta.
-  **DELETE:** Eliminar cuenta.

### **Transacciones (`/api/transactions`):**
- **POST:** Realizar un depósito.
- **POST:** Realizar un retiro (validando fondos).

---

## **Seguridad**
- Contraseñas almacenadas usando **BCrypt**.
- Autenticación y autorización implementadas con **Spring Security**.
- Acceso a los endpoints protegido por roles y permisos.


  ## **Encontrara la colección para probar cada una de las API en la carpeta "documentación"**

---

## **Pruebas**

### **Pruebas Unitarias:**
- Usando **JUnit** y **Mockito**.
- Pruebas para:
  - Controladores (integración con la API REST).

### **Patrón AAA (Arrange-Act-Assert):**
- **Arrange:** Configurar los datos y dependencias necesarias.
- **Act:** Ejecutar el método o funcionalidad a probar.
- **Assert:** Verificar los resultados esperados.

---

## **Configuración del Proyecto**

### **Archivo `application.yaml`**:
```yaml
spring:
  application:
    name: count
  datasource:
    url: jdbc:h2:mem:mydb
    username: sa
    password: password
    driverClassName: org.h2.Driver
    jpa:
      database-platform: org.hibernate.dialect.H2Dialect
```

---

## **Versionamiento**
- **Repositorio GitHub:**
  - metodologia trunk base
  - Estructura clara con commits descriptivos.
  - Uso de ramas para implementar nuevas funcionalidades.

---

---

**Autores:** Johan Sebastian Quimbayo

