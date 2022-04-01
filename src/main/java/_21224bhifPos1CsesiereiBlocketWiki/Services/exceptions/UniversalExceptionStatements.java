package _21224bhifPos1CsesiereiBlocketWiki.Services.exceptions;

public enum UniversalExceptionStatements {
    BLANK_OR_EMPTY_MSG("cannot be empty or blank!"),
    DATA_NOT_FOUND("cannot be accessed or does not exist!"),
    DUPLICATE_DATA_FOUND("is already created!"),
    WRONG_RANGE_INPUT(" is not in the expected range!");

    UniversalExceptionStatements(String msg){
        this.msg = msg;
    }
    public final String msg;

    @Override
    public String toString() { return msg; }
}
