package xm.chessboard.enumeration

import spock.lang.Specification
import spock.lang.Unroll

class ChessboardSpec extends Specification {

    def "Chessboard should contain 64 different chessboard positions"() {
        when:
            def response = EnumSet.allOf(Chessboard.class).size()

        then:
            response == 64
    }

    @Unroll
    def "Chessboard should contain 64 different chessboard positions with appropriate CartesianPair"() {
        when:
            def response = EnumSet.allOf(Chessboard.class)
                .find { it == input }

        then:
            with (response) {
                position == expectedPosition
                cartesianPair.i == expectedI
                cartesianPair.j == expectedJ
            }

        where:
            input         | expectedPosition | expectedI | expectedJ
            Chessboard.A1 | 'A1'             | 0         | 0
            Chessboard.A2 | 'A2'             | 0         | 1
            Chessboard.A3 | 'A3'             | 0         | 2
            Chessboard.A4 | 'A4'             | 0         | 3
            Chessboard.A5 | 'A5'             | 0         | 4
            Chessboard.A6 | 'A6'             | 0         | 5
            Chessboard.A7 | 'A7'             | 0         | 6
            Chessboard.A8 | 'A8'             | 0         | 7
            Chessboard.B1 | 'B1'             | 1         | 0
            Chessboard.B2 | 'B2'             | 1         | 1
            Chessboard.B3 | 'B3'             | 1         | 2
            Chessboard.B4 | 'B4'             | 1         | 3
            Chessboard.B5 | 'B5'             | 1         | 4
            Chessboard.B6 | 'B6'             | 1         | 5
            Chessboard.B7 | 'B7'             | 1         | 6
            Chessboard.B8 | 'B8'             | 1         | 7
            Chessboard.C1 | 'C1'             | 2         | 0
            Chessboard.C2 | 'C2'             | 2         | 1
            Chessboard.C3 | 'C3'             | 2         | 2
            Chessboard.C4 | 'C4'             | 2         | 3
            Chessboard.C5 | 'C5'             | 2         | 4
            Chessboard.C6 | 'C6'             | 2         | 5
            Chessboard.C7 | 'C7'             | 2         | 6
            Chessboard.C8 | 'C8'             | 2         | 7
            Chessboard.D1 | 'D1'             | 3         | 0
            Chessboard.D2 | 'D2'             | 3         | 1
            Chessboard.D3 | 'D3'             | 3         | 2
            Chessboard.D4 | 'D4'             | 3         | 3
            Chessboard.D5 | 'D5'             | 3         | 4
            Chessboard.D6 | 'D6'             | 3         | 5
            Chessboard.D7 | 'D7'             | 3         | 6
            Chessboard.D8 | 'D8'             | 3         | 7
            Chessboard.E1 | 'E1'             | 4         | 0
            Chessboard.E2 | 'E2'             | 4         | 1
            Chessboard.E3 | 'E3'             | 4         | 2
            Chessboard.E4 | 'E4'             | 4         | 3
            Chessboard.E5 | 'E5'             | 4         | 4
            Chessboard.E6 | 'E6'             | 4         | 5
            Chessboard.E7 | 'E7'             | 4         | 6
            Chessboard.E8 | 'E8'             | 4         | 7
            Chessboard.F1 | 'F1'             | 5         | 0
            Chessboard.F2 | 'F2'             | 5         | 1
            Chessboard.F3 | 'F3'             | 5         | 2
            Chessboard.F4 | 'F4'             | 5         | 3
            Chessboard.F5 | 'F5'             | 5         | 4
            Chessboard.F6 | 'F6'             | 5         | 5
            Chessboard.F7 | 'F7'             | 5         | 6
            Chessboard.F8 | 'F8'             | 5         | 7
            Chessboard.G1 | 'G1'             | 6         | 0
            Chessboard.G2 | 'G2'             | 6         | 1
            Chessboard.G3 | 'G3'             | 6         | 2
            Chessboard.G4 | 'G4'             | 6         | 3
            Chessboard.G5 | 'G5'             | 6         | 4
            Chessboard.G6 | 'G6'             | 6         | 5
            Chessboard.G7 | 'G7'             | 6         | 6
            Chessboard.G8 | 'G8'             | 6         | 7
            Chessboard.H1 | 'H1'             | 7         | 0
            Chessboard.H2 | 'H2'             | 7         | 1
            Chessboard.H3 | 'H3'             | 7         | 2
            Chessboard.H4 | 'H4'             | 7         | 3
            Chessboard.H5 | 'H5'             | 7         | 4
            Chessboard.H6 | 'H6'             | 7         | 5
            Chessboard.H7 | 'H7'             | 7         | 6
            Chessboard.H8 | 'H8'             | 7         | 7
    }
}
