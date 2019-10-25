
--a)
--SELECT * 
--FROM Game 
--ORDER BY time DESC;

--b)
--SELECT * 
--FROM Game 
--WHERE time > Now() - INTERVAL '7 days';

--c)
--SELECT * 
--FROM Player 
--WHERE name IS NOT NULL;

--d)
--SELECT score 
--FROM Player, PlayerGame 
--WHERE score > 2000;

--e)
--SELECT * 
--FROM Player WHERE emailAddress 
--LIKE '%gmail%'


--a)
--SELECT score
--From Player, PlayerGame
--Where Player.name = 'The King'
--  ORDER BY PlayerGame.score DESC;

--b)
--SELECT Player.name 
--FROM Player, Game, PlayerGame
--  WHERE Player.ID = PlayerGame.playerID
--    AND Game.ID = PlayerGame.gameID
--    AND Game.time = '2006-06-28 13:20:00'
--    ORDER BY PlayerGame.score DESC
--    LIMIT 1;

--c)
--SELECT P1.name
--FROM Player AS P1, Player AS P2
--WHERE P1.name = P2.name
--  AND P1.ID < P2.ID;
--P1.ID < P2.ID it compares both of them and returns the one that is bigger in the case that they have the same name

--d)
-- According to http://www.sqlservertutorial.net/sql-server-basics/sql-server-self-join/
-- a self join "is useful for querying hierarchical data or comparing rows within the same table"