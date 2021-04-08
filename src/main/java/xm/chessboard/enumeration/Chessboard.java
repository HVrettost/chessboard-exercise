package xm.chessboard.enumeration;

import xm.chessboard.model.CartesianPair;

public enum Chessboard {

    A1("A1", new CartesianPair(0, 0)),
    A2("A2", new CartesianPair(0, 1)),
    A3("A3", new CartesianPair(0, 2)),
    A4("A4", new CartesianPair(0, 3)),
    A5("A5", new CartesianPair(0, 4)),
    A6("A6", new CartesianPair(0, 5)),
    A7("A7", new CartesianPair(0, 6)),
    A8("A8", new CartesianPair(0, 7)),
    B1("B1", new CartesianPair(1, 0)),
    B2("B2", new CartesianPair(1, 1)),
    B3("B3", new CartesianPair(1, 2)),
    B4("B4", new CartesianPair(1, 3)),
    B5("B5", new CartesianPair(1, 4)),
    B6("B6", new CartesianPair(1, 5)),
    B7("B7", new CartesianPair(1, 6)),
    B8("B8", new CartesianPair(1, 7)),
    C1("C1", new CartesianPair(2, 0)),
    C2("C2", new CartesianPair(2, 1)),
    C3("C3", new CartesianPair(2, 2)),
    C4("C4", new CartesianPair(2, 3)),
    C5("C5", new CartesianPair(2, 4)),
    C6("C6", new CartesianPair(2, 5)),
    C7("C7", new CartesianPair(2, 6)),
    C8("C8", new CartesianPair(2, 7)),
    D1("D1", new CartesianPair(3, 0)),
    D2("D2", new CartesianPair(3, 1)),
    D3("D3", new CartesianPair(3, 2)),
    D4("D4", new CartesianPair(3, 3)),
    D5("D5", new CartesianPair(3, 4)),
    D6("D6", new CartesianPair(3, 5)),
    D7("D7", new CartesianPair(3, 6)),
    D8("D8", new CartesianPair(3, 7)),
    E1("E1", new CartesianPair(4, 0)),
    E2("E2", new CartesianPair(4, 1)),
    E3("E3", new CartesianPair(4, 2)),
    E4("E4", new CartesianPair(4, 3)),
    E5("E5", new CartesianPair(4, 4)),
    E6("E6", new CartesianPair(4, 5)),
    E7("E7", new CartesianPair(4, 6)),
    E8("E8", new CartesianPair(4, 7)),
    F1("F1", new CartesianPair(5, 0)),
    F2("F2", new CartesianPair(5, 1)),
    F3("F3", new CartesianPair(5, 2)),
    F4("F4", new CartesianPair(5, 3)),
    F5("F5", new CartesianPair(5, 4)),
    F6("F6", new CartesianPair(5, 5)),
    F7("F7", new CartesianPair(5, 6)),
    F8("F8", new CartesianPair(5, 7)),
    G1("G1", new CartesianPair(6, 0)),
    G2("G2", new CartesianPair(6, 1)),
    G3("G3", new CartesianPair(6, 2)),
    G4("G4", new CartesianPair(6, 3)),
    G5("G5", new CartesianPair(6, 4)),
    G6("G6", new CartesianPair(6, 5)),
    G7("G7", new CartesianPair(6, 6)),
    G8("G8", new CartesianPair(6, 7)),
    H1("H1", new CartesianPair(7, 0)),
    H2("H2", new CartesianPair(7, 1)),
    H3("H3", new CartesianPair(7, 2)),
    H4("H4", new CartesianPair(7, 3)),
    H5("H5", new CartesianPair(7, 4)),
    H6("H6", new CartesianPair(7, 5)),
    H7("H7", new CartesianPair(7, 6)),
    H8("H8", new CartesianPair(7, 7));

    private final String position;
    private final CartesianPair cartesianPair;

    Chessboard(String position, CartesianPair cartesianPair) {
        this.position = position;
        this.cartesianPair = cartesianPair;
    }

    public String getPosition() {
        return position;
    }

    public CartesianPair getCartesianPair() {
        return cartesianPair;
    }
}
