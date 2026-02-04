# Terminal 1:
```bash
clear && javac client/*.java  && javac common/service/*.java  && javac common/service/impl/*.java  && javac server/RmiServer.java && java server.RmiServer
```

---

# Terminal 2:
```bash
java client.RmiClient
```

---

# Terminal 3:
### (View results)
```bash
java client.SecondRmiClient
```