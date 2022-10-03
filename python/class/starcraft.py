# # 마린 : 공격 유닛, 군인, 총을 쏠 수 있음.
# from math import degrees


# name = "마린"
# hp = 40 # 체력
# damage = 5 # 공격력

# print("\n{} 유닛이 생성되었습니다.".format(name))
# print("체력 {0}, 공격력{1}".format(hp, damage))

# # 탱크 : 공격 유닛, 탱크, 포를 쏠 수 있는데, 일반 모드 / 시즈 모드
# tank_name = "탱크"
# tank_hp = 150
# tank_damage = 35

# print("\n{} 유닛이 생성되었습니다.".format(tank_name))
# print("체력 {0}, 공격력{1}".format(tank_hp, tank_damage))

# def attack(nae, location, damage) :
#   print("\n{0} : {1} 방향으로 적군을 공격합니다. 공격력 {2} ".format(name, location, damage))
  
# attack(name, "1시", damage)
# attack(tank_name, "1시", tank_damage)
# print()

class Unit :
  def __init__(self, name, hp) :
    self.name = name;
    self.hp = hp;

class AttackUnit :
  def __init__(self, name, hp, damage) :
    Unit.__init__(self, name, hp)
    self.damage = damage;
  
  def attack(self, location) :
    print("{0} : {1} 방향으로 적을 공격합니다. [공격력 {2}]".format(self.name, location, self.damage))
  
  def damaged(self, damage) :
    print("{0} : {1} 데미지를 입었습니다.".format(self.name, damage))

    self.hp -= damage
    print("{0} : 현재 체력은 {1} 입니다.".format(self.name, self.hp))
    
    if self.hp <= 0 :
      print("{0} : 파괴되었습니다.".format(self.name))
      
# 날 수 있는 기능을 가진 클래스 
class Flyable :
  def __init__(self, flying_speed) :
    self.flying_speed = flying_speed
    
  def fly(self, name, location) :
    print("{0} : {1} 방향으로 날아갑니다. [속도 {2}]".format(name, location, self.flying_speed))
    
# 공중 공격 유닛 클래스
class FlyableAttackUnit(AttackUnit, Flyable) :
  def __init__(self, name, hp, damage, flying_speed) :
    AttackUnit.__init__(self, name, hp, damage)
    Flyable.__init__(self, flying_speed)

# marine1 = Unit("마린", 40, 5)
# marine2 = Unit("마린", 40, 5)
# tank = Unit("탱크", 150, 35)
#marine3 = Unit("마린") # 오류 발생

# 레이스 : 공중 유닛, 비행기, 클로킹 (상대방에게 보이지 않음)
# wrait1 = Unit("레이스", 80, 5)
# print("유닛 이름 : {0}, 공격력 : {1}".format(wrait1.name, wrait1.damage))

# # 마인드 컨트롤
# wrait2 = Unit("빼앗은 레이스", 80, 5)
# wrait2.clocking = True;

# if wrait2.clocking == True :
#   print("{0} 는 현재 클로킹 상태입니다.".format(wrait2.name))

# 파이어뱃 : 공격 유닛, 화염방사기
firebat1 = AttackUnit("파이어뱃", 50, 16)
firebat1.attack("5시")

# 공격 2번 받는다고 가정
firebat1.damaged(25)
firebat1.damaged(25)

# 발키리 : 공중 공격 유닛, 한번에 14발 미사일 발사
valkyrie = FlyableAttackUnit("발키리", 200, 6, 5)
valkyrie.fly(valkyrie.name, "3시")