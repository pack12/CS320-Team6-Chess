package edu.ycp.cs320.team6.chess.model;

public interface PieceInterface {
	public boolean sees(int lookX, int lookY);
	public boolean checkPathOpen(int lookX, int lookY);
}
