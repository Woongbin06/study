# from traceback import print_tb


# try :
#   print("나누기 전용 계산기입니다.")
#   num1 = int(input("첫 번째 숫자를 입력하세요 : "))
#   num2 = int(input("두 번째 숫자를 입력하세요 : "));
#   print("{0} / {1} = {2}".format(num1, num2, int(num1 / num2)))
# except ValueError :
#   print("에러! 잘못된 값을 입력하였습니다.")
# except ZeroDivisionError as err :
#   print(err)
# except Exception as err :
#   print("알수 없는 에러가 발생하였습니니다.")
#   print(err)


  
from traceback import print_tb

try :
  print("나누기 전용 계산기입니다.")
  num1 = int(input("첫 번째 숫자를 입력하세요 : "))
  num2 = int(input("두 번째 숫자를 입력하세요 : "));
  if num1 >= 10 or num2 >= 10 :
      raise ValueError
  print("{0} / {1} = {2}".format(num1, num2, int(num1 / num2)))
except ValueError :
  print("에러! 잘못된 값을 입력하였습니다.")
except ZeroDivisionError as err :
  print(err)
except Exception as err :
  print("알수 없는 에러가 발생하였습니니다.")
  print(err)