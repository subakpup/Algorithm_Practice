while True:
    x = float(input())
    if x == -1.0:
        break
    y = x*0.167
    print(f'Objects weighing {x:.2f} on Earth will weigh {y:.2f} on the moon.')