import xmlrpc.client

PORT = 8000

def menu():
    print("[1]. Sum")
    print("[2]. Subtract")
    print("[3]. Multiply")
    print("[4]. Divide")
    print("[0]. Exit")

def main():
   proxy = xmlrpc.client.ServerProxy(f"http://localhost:{PORT}/")
   option = -1
   while option != 0:
      menu()
      option = int(input(">>> Choose an option: "))
      
      match option:
         case 1:
            a = int(input("First number: "))
            b = int(input("Second number: "))
            result = proxy.toSum(a, b)
            print(f"{a} + {b} = {result}")
         case 2:
            a = int(input("First number: "))
            b = int(input("Second number: "))
            result = proxy.toSubtract(a, b)
            print(f"{a} - {b} = {result}")
         case 3:
            a = int(input("First number: "))
            b = int(input("Second number: "))
            result = proxy.toMultiply(a, b)
            print(f"{a} * {b} = {result}")
         case 4:
            dividend = int(input("Dividend number: "))
            divisor = int(input("Divisor number: "))
            result = proxy.toDivide(dividend, divisor)
            print(f"{dividend} / {divisor} = {result}")
         case 0:
            print("Exiting...")
         case _:
            print(f"Unknow command: {option}")
               

if __name__ == "__main__":
    main()
