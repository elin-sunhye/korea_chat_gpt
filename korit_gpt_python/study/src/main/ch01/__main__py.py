import function
from function import add3, add2



if __name__ =="__main__":
    print("start")
    print(__name__)  # 현제 실행된 파일의 위치
    print(function.add3(10, 20, 30))
    print(add3(10, 20, 30))
    print("end")

    # 예외처리
    try:
        print("예외 처리")
        raise Exception("내가 만든 예외")
    except Exception as e:
        print("예외 발생")
        print(e)

