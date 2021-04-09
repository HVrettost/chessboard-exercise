package xm.chessboard.validator

import spock.lang.Specification
import spock.lang.Unroll

class ChessboardPositionValidatorSpec extends Specification {

    ChessboardPositionValidator validator

    def setup() {
        validator = new ChessboardPositionValidator()
    }

    @Unroll
    def "Should return false if given position value is not contained in the Chessboard enum class"() {
        when:
            def response = validator.isValid(position)

        then:
            !response

        where:
            position << ['G9', 'A0', 'hello', 'B10', 'X9', 'C13', 'Nick', 'M9', 'P34', 'g1', 'h8']
    }

    @Unroll
    def "Should return true if given position value is contained in the Chessboard enum class"() {
        when:
            def response = validator.isValid(position)

        then:
            response

        where:
            position << ['A1', 'A2', 'A3', 'A4', 'A5', 'A6', 'A7', 'A8',
                         'B1', 'B2', 'B3', 'B4', 'B5', 'B6', 'B7', 'B8',
                         'C1', 'C2', 'C3', 'C4', 'C5', 'C6', 'C7', 'C8',
                         'D1', 'D2', 'D3', 'D4', 'D5', 'D6', 'D7', 'D8',
                         'E1', 'E2', 'E3', 'E4', 'E5', 'E6', 'E7', 'E8',
                         'F1', 'F2', 'F3', 'F4', 'F5', 'F6', 'F7', 'F8',
                         'G1', 'G2', 'G3', 'G4', 'G5', 'G6', 'G7', 'G8',
                         'H1', 'H2', 'H3', 'H4', 'H5', 'H6', 'H7', 'H8']
    }
}
