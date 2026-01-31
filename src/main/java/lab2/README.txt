-------------------------------------------------------------------------------
|  Svar på frågor i uppgift 1                                                 |
-------------------------------------------------------------------------------
|1.  Bör ni använda implementationsarv (subclassing) eller specifikationsarv  |
|   (interfaces)? Varför? Kan båda användas? Vilka för- och nackdelar ser ni? |
|                                                                             |
|Svar: Implementationsarv används när man vill undvika kodduplicering på två  |
|      eller fler klasser med variabler och metoder som är lika.              |
|                                                                             |
|      Specifikationsarv används när man vill säkerställa att klassmetoder    |
|      beter sig på ett förutsagt sätt.                                       |
|------------------------------------------------------------------------------
|2.  Vilken synlighet bör ni använda för de olika metoder och variabler som   |
|    klasserna innehåller? Vilket gränssnitt bör ni exponera?                 |
|                                                                             |
|Svar: Getters och setters som inte används inom klasshierarkin exponeras     |
|      globalt. Likaså med metoderna för att starta och stoppa motorn samt    |
|      höja och sänka farten. Variabler och objekt som kan modifiera          |
|      klassobjektets interna tillstånd bör inte exponeras.                   |
|-----------------------------------------------------------------------------|
