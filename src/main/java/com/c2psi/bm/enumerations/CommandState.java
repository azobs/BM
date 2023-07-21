package com.c2psi.bm.enumerations;

public enum CommandState {
    InEditing, Edited, InDelivery, Delivery

    /******************************************************************************************
     * Lorsquon cree la commande elle est dans l'etat InEditing
     * Lorsq'on lance l'impression de la facture correspondante elle passe a l'etat Edited
     * a ce moment la commande peut encore etre edite mais la dans ce cas la facture precedement
     * imprime n'est plus valide et il faudra la supprimer
     * Lorsque le livreur sort avec la commande et se met en route on fait manuellement passe
     * commande a l'etat PackedUp pour dire En cours de livraison.
     * Une fois le rapport de livraison saisi, la commande passe a l'etat Delivery
     */
}
