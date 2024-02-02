## Autonomer LKW
Einzelleistung Komplexaufgabe
```code
Jahrgang:        TINF22A
Matrikelnummer:  666 14 35
```

## Fortschritt

| Pattern   | Code | Test |
|-----------|------|------|
| Builder   | 100% | 10%  |
| Mediator  | 100% | 0%   |
| Command   | 100% | 0%   |
| Composite | 0%   | 0%   |

## Anmerkungen
- Die Implementierung ist nicht perfekt, aber fuer 20h ganz gut geworden.
- Auf Enums wurde verzichtet. Linke und rechte Blinker sind wie folgt nummeriert:
```code
0 = links
1 = rechts
```
- Event System wurde selbst implementiert, ohne *Guava*. Es wird empfohlen, dieses nicht mehr zu benutzen und ich moechte, dass man mein Programm auch noch in 10 Jahren kompilieren kann - ohne veraltete Libs.