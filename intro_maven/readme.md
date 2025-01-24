scope -> indica quando una libreria deve essere utilizzata

Goal di maven -> sono tutte le funzionalità che ritroviamo all'interno della sezione mave->nome_progetto->lifecycle
- clean -> pulisce il nostro progetto da tutti i pacchetti jar creati
- compile -> ricrea i pacchetti jar, considerando anche tutte le modifiche apportate


Inversion of Control
- Vuol dire che non avremo più noi il controllo sulla istanziazione delle classi, quindi la creazione degli oggetti, ma lo fara spring framework per noi


AppConfig non è un nome a caso. In rreltà per le configurazione verrà tradotto che questa classe è una classe di configurazione di App cioè la classe principale. (se avessimo dovuto fare delle configurazioni generali la classe si sarebbe chiamata semplicemente Configuration)

@Configuration oltre ad essere una annotatin sta già definendo uno dei Bean del nostro applicativo

Pattern
- Singleton -> Istanzio un solo oggetto di una dereminata classe
- Prototype -> Istanzio più oggetti di una dereminata classe


In un progetto Spring Framework avremo:
- Model -> Classi che descrivono la struttura di un oggetto
- Controller -> Classi che contengono la logica legata alle viste, o alle risposte verso l'esterno(API)
- Service -> Classi che contengono la logica di business
- Repository -> Classi che hanno l'unico compito di comunicare con il DB (e sono le sole ed uniche che possono farlo)

Logica di business = La logica (quindi il codice/algoritmi) legata l particolare business(domina) 


@Repository("jeegRepository")  -> Definisce un bean all'interno del context che si chiama con il nome specificato "jeegRepository"
@Component("jeegService") -> Definisce un bean all'interno del context che si chiama con il nome specificato "jeegService" 
                             questa annotation definisce che la classe è un componente dell'applicazione useremo per i servic il @Service
                             che al suo interno possiede la definizione di @Component
@Autowired -> ci consentirà di effettuare la dependency injection di un determinato bean