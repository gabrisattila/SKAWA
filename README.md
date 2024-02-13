# SKAWA

## Első feladat:
Készíts yaml fordítót, mely tetszőleges szabvány YAML fájlból kinyerni a value-kat, és megfordítva visszaírja (spell backwards). 
A kulcsokat, kommenteket érintetlenül hagyja.

Input:
```
---
 doe: "abcd"
 pi: 3.14159
 xmas: true
 french-hens: 3
 calling-birds:
   - huey
   - dewey
   - louie
   - fred
 xmas-fifth-day:
   calling-birds: four
   french-hens: 3
   golden-rings: 5
   partridges:
     count: 1
     location: "abcd"
   turtle-doves: two
- 
```

Output
```
---
 doe: "dcba"
 pi: 3.14159
 xmas: true
 french-hens: 3
 calling-birds:
   - yeuh
   - yewed
   - eiuol
   - derf
 xmas-fifth-day:
   calling-birds: ruof
   french-hens: 3
   golden-rings: 5
   partridges:
     count: 1
     location: "dcba"
   turtle-doves: owt
```

## Második feladat:
Készíts rendszert, ami egy URL-ből kiindulva bejár egy website-ot (az adott domainen belül maradva), 
mindig lekövetve és feldolgozva az adott oldalon  megtalálható linkeket (csak ```<a href="">```, csak az adott domainen belül!). 
Ha már nincs több (új) oldal, álljon meg. Utána képes legyen válaszolni, hogy két tetszőleges, megadott URL között mi a legrövidebb út, 
és az milyen hosszú. Feltételezheted, hogy  a megoldások során elegendő memória áll a rendelkezésedre.

## Harmadik feladat: Skálázódó tömeges hash számolás
A feladat, hogy egy skálázódó, elosztott rendszerrel számoljuk ki 1000 db, szervertől lekért stringre a bcrypt hasht, 15-ös strength/cost paraméterrel, 
majd küldjük vissza az eredményt. A hash számolást végző rendszerben a és több példányban fusson, 
hogy párhuzamosan végre tudja hajtani az egy adagban érkező 1000 db hash kiszámolását. Egy programpéldány nem használhat 4 CPU magnál több erőforrást, 
azaz a párhuzamosságot ne a szálak növelésével, hanem ténylegesen több programpéldány (több gépen) történő futattásával érje el.
A megoldás legyen hibatűrő, a részfeladatok összegyűjtését végző folyamat/gép leállása esetén később adatvesztés nélkül tudjon folytatódni.
Előnyt jelent, ha a megoldás fel van készítve arra az esetre, ha nem csak 1000, hanem annyi hash kiszámolása szükséges, 
ami a válasz visszaküldésekor nem fér el egyszerre a memóriában. A saját tesztek alapján 1 szálon/CPU magon kb. 3 mp egy hash kiszámolása, 
az 1000 hash számolása kb 50 percig tartana. A cél, hogy minél gyorsabban be tudjuk küldeni az eredményt, ideális esetben 2-3 percen belül.
Bármilyen felhőszolgáltató bármelyik párhuzamos feldolgozást elősegítő szolgáltatása használható.

