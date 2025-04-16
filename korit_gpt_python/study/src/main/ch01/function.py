def add(num1, num2):
    return num1 + num2, num1, num2 # tuple로 묶어서 리턴
# print(add(10, 20))
# n1, n2, n3 = add(10, 20)
# print(n1)
# print(n2)
# print(n3)

def add(num1, num2, num3):
    return num1, num2, num3

# print(add(10, 20, 30))
# print(add(10, 20)) # 오버로딩 안됨

def add(num1, num2, num3 = 0): # 기본값은 샌드위치나 앞부분만 설정할 수 없다 (num1 = 0, num2, num3 = 0) || num1, num = 0, num3)
    return num1, num2, num3
# print(add(11, 21, 31))
# print(add(12, 22)) # 오버로딩 됨

def add(num1:str="0", num2 = 0, num3 = 0):
    return num1, num2, num3
# print(add(13, 23, 33))
# print(add([10]))

def add2(*a):
    print(a)
    result = 0
    for n in a:
        result += n
    return result

def add3(*b):
    print(__name__)
    return sum(b)

if __name__ == "__main__":
    print(add(10, 20))
    n1, n2, n3 = add(10, 20)
    print(n1)
    print(n2)
    print(n3)
    print(add2(1, 2, 3, 4, 5, 6))
    print(add3(1,2,3,4,5))
    print(add(13, 23, 33))
    print(add([10]))
    print(add(10, 20, 30))
    # print(add(10, 20)) # 오버로딩 안됨
    print(add(11, 21, 31))
    print(add(12, 22))  # 오버로딩 됨