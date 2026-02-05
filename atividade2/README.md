# 🗳️ Java RMI Voting System

Projeto simples em Java utilizando **RMI (Remote Method Invocation)**, composto por:

- Servidor RMI
- Cliente principal
- Cliente secundário (visualização de resultados)

Todos executados localmente.

---

# 🐧 Linux / macOS
Abra 3 terminais diferentes dentro da pasta src.

 # ▶ Terminal 1 — Compilar e iniciar o servidor
```bash
clear && \
javac client/*.java && \
javac common/service/*.java && \
javac common/service/impl/*.java && \
javac server/RmiServer.java && \
java server.RmiServer
```

---

# ▶ Terminal 2 — Cliente principal (votação)
```bash
java client.RmiClient
```
---

 # ▶ Terminal 3 — Cliente secundário (visualizar resultados)
```bash
java client.SecondRmiClient

```

---

# 🪟 Windows (CMD)
Abra 3 janelas diferentes dentro da pasta src.

 # ▶ Terminal 1 — Compilar e iniciar o servidor
```bash
cls
javac client\*.java
javac common\service\*.java
javac common\service\impl\*.java
javac server\RmiServer.java
java server.RmiServer
```

---

# ▶ Terminal 2 — Cliente principal
```bash
java client.RmiClient
```
---

 # ▶ Terminal 3 — Cliente secundário (visualizar resultados)
```bash
java client.SecondRmiClient
```

