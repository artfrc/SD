import socket
import threading

HOST = socket.gethostname()
PORT = 12345

def broadcast(clients, message, sender_conn):
    for client in list(clients):
        if client != sender_conn:
            try:
                client.send(message)
            except:
                clients.remove(client)

def handle_client(clients, conn, addr):
    print(f"\n>>> New connection: {addr}\n")

    while True:
        try:
            message = conn.recv(1024)
            if not message:
                break

            text = message.decode().strip()

            if text.lower() == "disconnect":
                break

            print(f"[{addr}] {text}")
            broadcast(clients, f"[{addr}] {text}\n".encode(), conn)
        except:
            break

    if conn in clients:
        clients.remove(conn)
    conn.close()
    print(f"\n>>> Client disconnected: {addr}\n")


def main():
    clients = []

    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((HOST, PORT))
    server.listen()

    print(">>> Server started and waiting for first client...\n")

    conn, addr = server.accept()
    clients.append(conn)

    threading.Thread(target=handle_client, args=(clients, conn, addr), daemon=True).start()

    print(">>> First client connected. Server now requires clients to stay alive...\n")

    server.settimeout(2)

    while True:
        if len(clients) == 0:
            try:
                conn, addr = server.accept()
                clients.append(conn)
                threading.Thread(target=handle_client, args=(clients, conn, addr), daemon=True).start()
            except socket.timeout:
                print(">>> No more clients. Server shutting down...\n")
                break
        else:
            try:
                conn, addr = server.accept()
                clients.append(conn)
                threading.Thread(target=handle_client, args=(clients, conn, addr), daemon=True).start()
            except socket.timeout:
                pass

    server.close()
    print(">>> Server closed.\n")

if __name__ == "__main__":
    main()
