package edu.ycp.cs320.team6.chess.model;

public interface PieceInterface {
	public boolean sees(int lookX, int lookY);
	public boolean checkPathOpen(int lookX, int lookY);
	public default boolean validateMove(int lookX, int lookY) {
		if(sees(lookX, lookY)) {
			return checkPathOpen(lookX, lookY);
		}
		else {
			return false;
		}
	}
}
