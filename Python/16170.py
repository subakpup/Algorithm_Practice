import datetime
now = datetime.datetime.now() - datetime.timedelta(hours=9)

print(now.year)
print('%02d'%now.month)
print('%02d'%now.day)