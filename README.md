# Cyberia Backend

El siguiente repositorio se va a usar únicamente para la creación de la programación en JAVA y Mysql

## Forma de organizar los archivo en JAVA

![example controller JAVA](Img/javaControllerExample.png)

## Imagen del UML

![cyberia store UML](Img/CyberiaStoreUML.png)

## Imagen de la Base de Datos

![base_de_datos_img](BaseDeDatos/Img/CyberiaStore.png)

## Forma de organizar los script en la BD

Forma como vamos a trabajar los script de la base de datos.

```
/BaseDeDatos
    /configuracion_estructura   # Scripts de creación de la estructura de la base de datos.
    /datos_esenciales           # Datos esenciales que necesita la aplicación para funcionar: configuración básica, roles, datos maestros.
    /migraciones_de_datos       # Scripts de migración para cambios incrementales en la estructura o en los datos de la base de datos.
    /datos_de_prueba            # Datos de prueba que se utilizan para desarrollo, pruebas unitarias o ambientes de staging.
    /procedimientos_almacenados # Procedimientos almacenados, funciones y triggers de la base de datos.
    /vistas                     # Scripts de creación y actualización de vistas.
    /scripts_de_respaldo        # Scripts o instrucciones para generar y restaurar backups de la base de datos.
```

## 