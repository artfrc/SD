import socket                  

s = socket.socket()            
host = socket.gethostname()    
port = 12345           

s.connect((host, port))

while True:

   message = input("Cliente diga algo: ")
   s.send(message.encode())

   if message == "SAIR":
      resposta = s.recv(1024).decode()
      print("Servidor:", resposta)
      break

   data = s.recv(1024).decode()
   print("Servidor:", data)

s.close()
