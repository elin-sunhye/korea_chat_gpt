# print
print("hello python1")
print("hello python2", end=" ")
print("hello python3", end=" !!!")
print()

#
num = 33
name = "김선혜"
print(num == 33)
isEmpty = False and True # False & True

# 여러줄
txt= """
    aaa
    aaaa
    aaaaa
"""
print(txt)

# 주소 확인 함수 id()
print(id(num), id(33))

# 변수 출력
name = "김선혜"
age = 30
profile = "이름: {0}, 나이: {1}".format(name, age)
print(profile)