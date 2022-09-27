from calendar import day_abbr
from dataclasses import dataclass
from socket import *
from sqlite3 import SQLITE_ALTER_TABLE

s_ip = "localhost"
s_port = 12347
s_addr = (s_ip, s_port)

s_sock = socket(AF_INET, SOCK_DGRAM)
s_sock.bind(s_addr)
s_sock.setsockopt(SOL_SOCKET, SO_REUSEADDR, 1)

data, c_addr = s_sock.recvfrom(1024)

while data.decode("utf-8") != "q" :
  print("클라이언트 주소 : ", c_addr)
  print("수신자료 : ", data.decode("utf-8"))
  print()
  s_sock.sendto(data, c_addr)
  data, c_addr = s_sock.recvfrom(1024)

s_sock.close()