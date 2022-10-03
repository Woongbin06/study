class Human :
  def __init__(self, height, age) :
    self.height = height;
    self.age = age;
    
  def how_old(self) :
    print(self.age, "살입니다.")
    
  def how_tall(self) :
    print(self.height, "cm 입니다.")

woongbin = Human(170, 17)
deasung = Human(174, 19)

woongbin.how_old()
Human.how_old(woongbin)

deasung.how_tall()
print(woongbin.height)