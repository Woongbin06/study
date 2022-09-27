from socket import *

s_ip = "localhost"
s_prot = 12347
s_addr = (s_ip, s_prot)

c_sock = socket(AF_INET, SOCK_DGRAM)

inputData = input("문자열 입력")
c_sock.sendto(inputData.encode("utf-8"))

while inputData != "q" :
  data, addr = c_sock.recvfrom(1024)

  print("돌아온 글자는 : ", data.decode("utf-8"))

  inputData = input("문자열 입력 : ")
  c_sock.setdto(inputData.encode("utf-8"))

c_sock.close()