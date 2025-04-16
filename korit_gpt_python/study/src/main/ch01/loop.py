# 들여쓰기 중요!!!
numbers = [1, 2, 3, 4, 5]
for num in numbers:
    print(num)
print(num)

# 리스트 생성
print(list(range(10)))

# 반복문 조건
for n in range(5, 10):
    print(n)

while True:
    selected = input("입력: ")
    if selected in ['q', 'Q']:
        break
