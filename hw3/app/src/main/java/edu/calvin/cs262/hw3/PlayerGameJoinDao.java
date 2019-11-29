package edu.calvin.cs262.hw3;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * PlayerGameJoinDao (data access object) allows easy interaction with db PlayerGameJoin table
 * Defines joining queries for getting players from gameId and getting games from playerID
 */
@Dao
public interface PlayerGameJoinDao {
    @Insert
    void insert(PlayerGameJoin playerGameJoin);

    // Get players from gameId
    @Query("SELECT * FROM player_table " +
            "INNER JOIN player_game_join " +
            "ON player_table.id=player_game_join.playerId " +
            "WHERE player_game_join.gameId=:gameId")
    LiveData<List<Player>> getPlayersForGame(final int gameId);

    // Get games from playerID
    @Query("SELECT * FROM game_table " +
            "INNER JOIN player_game_join " +
            "ON game_table.id=player_game_join.gameId " +
            "WHERE player_game_join.playerId=:playerId")
    LiveData<List<Game>> getGamesForPlayer(final int playerId);

    @Query("DELETE FROM player_game_join")
    void deleteAll();

    @Delete
    void deletePlayerGameJoin(PlayerGameJoin playerGameJoin);

    @Query("SELECT * from player_game_join")
    LiveData<List<PlayerGameJoin>> getAllPlayerGameJoins();

    @Query("SELECT * from player_game_join LIMIT 1")
    PlayerGameJoin[] getAnyPlayerGameJoin();

}