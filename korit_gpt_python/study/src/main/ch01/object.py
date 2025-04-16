class Student:

    # self : 객체의 주소(참조주소)
    def __init__(self, name): # 생성자
        self.name = name
        print("생성자 호출")

    def printInfo(self):
        print("학생정보 출력")
        print(f"name: {self.name}")

    @staticmethod
    def printId():
        print("아아디 출력")

    def __str__(self): # tostring()
        return f"이름: {self.name}"

s1 = Student("김선혜")
print("object 주소: ", s1)
s1.printInfo()
Student.printId()