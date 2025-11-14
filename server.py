import socket                

s = socket.socket()          
host = socket.gethostname()  
port = 12345                
s.bind((host, port))         

s.listen(5)
print("Servidor aguardando clientes...")

c, addr = s.accept()     
print('Got connection from', addr)

while True:
    message_client = c.recv(1024).decode()
    print("Cliente disse:", message_client)

    if message_client == "SAIR":
        c.send("TCHAU".encode())
        break

    resposta = input("Servidor diga algo: ")
    c.send(resposta.encode())

c.close()
s.close()
