from random import *
# 일반 유닛
class Unit:
    def __init__(self, name, hp, speed) :
        self.name = name
        self.hp = hp
        self.speed = speed
        print(f"{name} 유닛이 생성되었습니다.")

    def move(self, location):
        print("[지상 유닛 이동]")
        print(f"{self.name} : {location} 방향으로 이동합니다. [속도 {self.speed}]")

    def damaged(self, damage):
        print(f'{self.name} : {damage} 대미지를 입었습니다.')
        self.hp -= damage
        print(f'{self.name} : 현재 체력은 {self.hp}입니다.')
        if self.hp <=0:
            print(f"{self.name} : 파괴되었습니다.")

# 공격 유닛
class AttackUnit(Unit):
    def __init__(self, name, hp, speed, damage) :
        Unit.__init__(self, name, hp, speed)
        self.damage = damage
    
    def attack(self, location):
        print(f"{self.name} : {location} 방향으로 적군을 공격합니다. [공격력 {self.damage}]")

class Marine(AttackUnit):
    def __init__(self):
        AttackUnit.__init__(self, "마린", 40, 1, 5)

    # 스팀팩
    def stimpack(self):
        if self.hp > 10:
            self.hp -= 10
            print(f'{self.name} : 스팀팩을 사용합니다.')
        else:
            print(f'{self.name} : 체력이 부족하여 스팀팩 사용이 취소되었습니다.')

class Tank(AttackUnit):
    seize_develped = False

    def __init__(self):
        AttackUnit.__init__(self, "탱크", 150, 1, 35)
        self.seize_mode = False

    def set_seize_mode(self):
        if Tank.seize_develped == False:
            return
        
        if self.seize_mode == False:
            print(f'{self.name} : 시즈모드로 전환합니다.')
            self.damage *= 2
            self.seize_mode = True
        else:
            print(f'{self.name} : 시즈모드를 해제합니다.')
            self.damage //= 2
            self.seize_mode = False

# 드랍쉽
class Flyable:
    def __init__(self, name, flyingspeed):
        self.name = name
        self.flyingspeed = flyingspeed
    
    def fly(self, location):
        print(f"{self.name} : {location} 방향으로 날아갑니다. [속도 {self.flyingspeed}]")

# 공중 공격 유닛 클래스
class FlyableAttackUnit(AttackUnit, Flyable):
    def __init__(self, name, hp, damage, flyingspeed):
        AttackUnit.__init__(self, name, hp, 0, damage) # 지상 스피드 0
        Flyable.__init__(self, name, flyingspeed)

    def move(self, location):
        print("[공중 유닛 이동]")
        self.fly(location)

class Wraith(FlyableAttackUnit):
    def __init__(self):
        FlyableAttackUnit.__init__(self, "레이스", 80, 20, 5)
        self.clocked = False

    def clocking(self):
        if self.clocked == True:
            print(f'{self.name} : 클로킹 모드 해제합니다.')
            self.clocked == False
        else:
            print(f'{self.name} : 클로킹 모드로 설정합니다.')
            self.clocked == True

def game_start():
    print("[알림] 새로운 게임을 시작합니다.")

def game_over():
    print("Player : gg")
    print("[Player] 님이 게임에서 퇴장하셨습니다.")

# 게임 시작
game_start()

m1 = Marine()
m2 = Marine()
m3 = Marine()

t1 = Tank()
t2 = Tank()

w1 = Wraith()

# 유닛 일괄 관리
attack_units = []
attack_units.append(m1)
attack_units.append(m2)
attack_units.append(m3)
attack_units.append(t1)
attack_units.append(t2)
attack_units.append(w1)

for unit in attack_units:
    unit.move('1시')

# 시즈모드
Tank.seize_develped = True
print("[알림] 탱크 시즈 모드 개발이 완료되었습니다.")

# 공격 모드 준비 (마린 : 스팀팩, 탱크 : 시즈모드, 레이스 : 클로킹)
for unit in attack_units:
    if isinstance(unit, Marine):
        unit.stimpack()
    elif isinstance(unit, Tank):
        unit.set_seize_mode()
    elif isinstance(unit, Wraith):
        unit.clocking()

# 공격 시작
for unit in attack_units:
    unit.attack("1시")

# 피해
for unit in attack_units:
    unit.damaged(randint(5,21)) # 공격은 랜덤으로 받음

# 게임 종료
game_over()