# set, list
numberList = list() # numberList = []

numberList.append(10)
numberList.append('가')
numberList.append(["1", "2", "3"])
print(numberList)

nameDict = dict() # nameDict = {}
nameDict["name1"] = "김선혜"
nameDict["name2"] = "안형우" # nameDict = {'name1': '김선혜', 'name2': '안형우'}
print(nameDict)
print(nameDict.get("name1"))
print(nameDict["name2"])
print(nameDict.keys())
print(nameDict.values())
print(nameDict.items()) # entry (key-value)

# 튜플
nameList = ["김다혜", "최한성", "김선혜"]
nameTuple = ("김다혜", "최한성") # 불편 리스트 (값 추가 삭제 불가능)
for name in nameList:
    print(name)
for name in nameTuple:
    print(name)

# 튜플 형 변환
nameList =  list(nameTuple)

# 리스트 합치기
nameList2 = nameList + list(nameTuple) # 새로운 리스트
nameList.extend(list(nameTuple)) # 기존 리스트에 추가
print(nameList2)
print(nameList)