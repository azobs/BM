package com.c2psi.bm.enumerations;

public enum DeliveryState {
    InEditing, Edited, Delivery
    /******************************************
     * Lorsquon cree ou prepare une livraison elle se met direct en etat InEditing
     * Lorsqu'on finit d'y placer des commandes et qu'on imprine le bordereau de
     * livraison elle passe a l'etat Edited.
     * Lorsque le livreur la livre jusqua le client confirme, la livraison passe
     * a l'etat Delivery. C'est le livreur qui le fait explicitement.
     */
}
