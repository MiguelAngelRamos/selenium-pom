### 📋 Cuando una clase en Java tiene miembros `static` (métodos, atributos, bloques):

✅ Esos miembros **pertenecen a la clase**, no a los objetos.
✅ Por eso, **no necesitas crear una instancia de la clase** para acceder a ellos.

---

### 📦 La “carga” de la clase

Lo que tú llamas “carga” (y así se llama en la JVM) es este proceso:
1️⃣ La primera vez que haces algo que requiere la clase (por ejemplo:

* Llamar a un método `static`.
* Acceder a un atributo `static`.
* Crear una instancia con `new`),
  la JVM **carga la clase en memoria**.

2️⃣ Como parte de esa carga:

* Se inicializan los atributos `static` con sus valores.
* Se ejecutan los **bloques `static`** (si hay alguno).
* Queda listo para usar.

📝 Esto ocurre **una sola vez por clase** en todo el ciclo de vida de la aplicación (a menos que la clase se descargue y se vuelva a cargar en un ClassLoader nuevo).

---

### 🖋 Ejemplo ilustrativo

```java
class Demo {

    static {
        System.out.println("👉 Clase cargada (bloque static)");
    }

    static void metodoStatic() {
        System.out.println("✅ Método static ejecutado");
    }

    Demo() {
        System.out.println("🚀 Constructor (instancia creada)");
    }
}

public class Main {
    public static void main(String[] args) {
        Demo.metodoStatic();       // Aquí ya se carga la clase
        System.out.println("---");
        Demo demo = new Demo();    // No vuelve a cargar la clase
    }
}
```

### 🖋 Salida:

```
👉 Clase cargada (bloque static)
✅ Método static ejecutado
---
🚀 Constructor (instancia creada)
```
