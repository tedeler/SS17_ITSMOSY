import RPi.GPIO as GPIO   # GPIO Bibliothek importieren
import time               # Modul time importieren

P = 37                    # Verwende Pin 37

GPIO.setmode(GPIO.BOARD) # Verwende Board-Pinnummern
GPIO.setup(P, GPIO.IN)   # Setze Pin P als Eingang

for i in range(100):         # 100 mal laufen
    value = GPIO.input(P)    # Wert auslesen
    print(value)             # Wert ausgeben
    time.sleep(0.1)          # 100ms warten

GPIO.cleanup()           # Aufräumen