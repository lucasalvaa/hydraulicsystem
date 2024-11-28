# Hydraulic System
- Interfaccia **Component**: contiene i due metodi per:
  - Calcolare il flusso d’acqua in uscita dato un flusso in ingresso (metodo _double outputFlow(double inputFlow)_)
  - Fornire una descrizione testuale che evidenzi le caratteristiche principali del componente (metodo _void printInfo()_)

- Le quattro classi **Pump**. **Tube**, **Valve** e **WaterTank** riproducono rispettivamente il funzionamento di una pompa idraulica, di un tubo, di una valvola e di un serbatoio d'acqua
- Tutte e quattro implementano l'interfaccia **Component**, implementando il metodo _double outputFlow(double inputFlow)_ secondo le richieste della traccia

- La classe **HydraulicSystem** contiene quattro attributi, ovvero un oggetto di ognuna delle quattro suddette classi.
- La classe mette a disposizione i metodi:
  - **_boolean openValve()_** - apre la valvola se è chiusa
  - **_boolean closeValve()_** - apre la valvola se è aperta
  - **_boolean fillTank()_** - riempie il serbatoio al massimo
  - **_double testComponent(double inputFlow, final int component)_** - testa il comportamento di un flusso d'acqua attraverso un solo componente
  - **_double testInSeries(double inputFlow, final int ...components)_** - testa il comportamento di un flusso d'acqua attraverso una serie di componenti
  - **_printInfo(final int component)_** - stampa le info di un determinato componente<\br>

I valori interi associati ai componenti da passare alle funzioni sono (1) per il tubo, (2) per la pompa idraulica, (3) per la valvola e (4) per il serbatoio.

Ognuno dei suddetti metodi, ad eccezione dei _printfInfo()_, è prettamente commentato nella sezione di codice.

## Richieste
Ecco dove sono state esaudite le richieste della traccia:
### Punto 1
```
Configurare un sistema idraulico composto dai seguenti componenti:
- Un tubo che riduce il flusso di una quantità fissa.
- Una pompa che amplifica il flusso in ingresso.
- Una valvola inizialmente aperta.
- Un serbatoio cilindrico con una capacità massima prefissata.
```
Il punto 1 è soddisfatto dal costruttore della classe **HydraulicSystem**:
```java
public HydraulicSystem (Tube t, Pump p, Valve v, WaterTank wt) {
  tube = t;
  pump = p;
  valve = v.open();
  tank = wt;
}

public HydraulicSystem () {
  this(new Tube(), new Pump(), new Valve(), new WaterTank());
}
```
Da notare che questo costruttore invoca il metodo open() sulla valvola, poiché di base le valvole vengono istanziate come chiuse.

### Punto 2
```
Simulare il flusso d’acqua attraverso i componenti configurati:
- Calcolando il flusso attraverso un singolo componente dato un valore di input.
- Calcolando il flusso che attraversa una sequenza di componenti.
```
Nella classe HydraulicSystem vengono implementati i metodi
- **_double testComponent(double inputFlow, final int component)_**
- **_double testInSeries(double inputFlow, final int ...components)_**
per soddisfare questa richiesta. 

### Punto 3
```
Modificare lo stato della valvola (aperta/chiusa) e verificare il suo effetto sul flusso complessivo.
```
Nel metodo **main** della classe Tester vengono fatti i seguenti test:
```java
hs.closeValve();
hs.printInfo(VALVE);
System.out.println("Valve tested with 100 litres while closed - output: " + hs.testComponent(100, VALVE));
hs.openValve();
hs.printInfo(VALVE);
System.out.println("Valve tested with 100 litres after being opened - output: " + hs.testComponent(100, VALVE));
```

### Punto 4
```
Simulare il comportamento del serbatoio in diverse condizioni:
1. Quando viene riempito fino alla capacità massima.
2. Quando viene svuotato parzialmente.
3. Gestendo situazioni in cui il livello d’acqua supera i limiti.
```

Il metodo **_outputFlow()_** della classe WaterTank gestisce già il primo ed il terzo scenario:
```java
public double outputFlow (double inputFlow) {
  /**
   * If the water injected could be cointaned in the tank, the output flow is empty.
   */
  if (waterInside + inputFlow <= maxCapacity) {
    waterInside += inputFlow;
    return 0.0;
  }
  /**
   * Otherwise, the tank is filled and the exceeded water is sent to the output flow.
   */
  else {
    inputFlow = (waterInside + inputFlow) - maxCapacity;
    this.fill();
    return inputFlow;
  } 
}
```
Per quanto riguarda il secondo scenario, è stato implementato il metodo **_getOutWater()_** nella classe WaterTank:
```java
/**
 * Removes a certain amount of water from the tank.
 * If the required amount of water exceeds the amount of water contained in the tank, nothing happens.
 */
public double getOutWater (double amount) {
  if (!isEmpty() && (0 <= waterInside - amount)) {
    waterInside -= amount;
    return amount;
  }

  return 0.f;
}
```

  
