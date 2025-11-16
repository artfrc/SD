from xmlrpc.server import SimpleXMLRPCServer

PORT = 8000

def toSum(a, b):
   return a + b

def toSubtract(a, b):
   return a - b

def toMultiply(a, b):
   return a * b

def toDivide (dividend, divisor):
   if divisor == 0:
        return "[ERROR]: It is not possible to divide a number by zero."
   
   return dividend/divisor

def main():
   server = SimpleXMLRPCServer(("localhost", PORT))
   
   server.register_function(toSum, "toSum")
   server.register_function(toSubtract, "toSubtract")
   server.register_function(toMultiply, "toMultiply")
   server.register_function(toDivide, "toDivide")
   
   print(f"Serving XML-RPC on port {PORT}...")
   server.serve_forever()
   
if __name__ == "__main__":
    main()
   