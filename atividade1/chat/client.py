import socket
import threading

HOST = socket.gethostname()
PORT = 12345

def receive_messages(sock):
    while True:
        try:
            message = sock.recv(1024)
            if not message:
                break
            print(f"\n{message.decode()}\n>>> ", end="")
        except:
            break
        
def main():
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.connect((HOST, PORT))

    threading.Thread(target=receive_messages, args=(client,), daemon=True).start()

    print(">>> Connected to chat, type 'disconnect' to exit.\n")

    while True:
        msg = input(">>> ")
        client.send(msg.encode())

        if msg.lower() == "disconnect":
            break

    client.close()
    print("\n>>> You disconnected.\n")
    
if __name__ == "__main__":
    main()
