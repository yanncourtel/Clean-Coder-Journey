### TripService objectif

Refactorer la classe trip_service

### TripService deroule

1) Explication de la contrainte : on ne touche pas au code de production s'il n'est pas teste completement.
    - Exception, action automatisee de l'IDE.
    - il est possible de renommer
2) Analyse du premier cas a tester
    - la branche de code la plus simple : cas d'erreur UserNotLoggedInException
3) Premier test : Une exception se lance lors de l'acces a l'objet UserSession
    - Action automatise pour ajouter un field UserSession
    - Utiliser Mockito pour mocker le champ UserSession et le retour de la methode getLoggedUser dans les tests
4) Second test : Une liste vide de Trips est renvoye si le user loggue n'a pas d'ami.
5) Troisiéme test : Une liste vide de Trips est renvoye si le user loggue n'est pas ami avec celui passe en parametre
5) Quatriéme test : Une liste  de Trips est renvoye si le user loggue est ami avec celui passe en parametre
      -créer un service heritant notre classe testé pour overide le code qui accede a tripDao

6) refactor