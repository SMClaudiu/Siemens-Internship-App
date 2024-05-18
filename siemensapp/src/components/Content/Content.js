import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import Button from '@mui/material/Button';
import ButtonGroup from '@mui/material/ButtonGroup';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
}));

export default function HotelsCard() {
  const [expanded, setExpanded] = useState({});
  const [hotels, setHotels] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetch('http://localhost:8080/hotels/getAll')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        console.log('Received hotel data:', data);
        setHotels(data);
      })
      .catch(error => console.error('Error fetching hotels:', error));
  }, []);

  const handleExpandClick = (id) => {
    setExpanded((prevState) => ({
      ...prevState,
      [id]: !prevState[id],
    }));
  };

  const handleCheckInClick = (id) => {
    navigate(`/hotel/${id}/rooms`);
  };

  return (
    <>
      {hotels.map((hotel) => (
        <Card key={hotel.id} sx={{ maxWidth: 345, marginBottom: 2 }}>
          <CardHeader
            avatar={
              <Avatar sx={{ bgcolor: red[500] }} aria-label="hotel">
                {hotel.name.charAt(0)}
              </Avatar>
            }
            title={hotel.name}
          />
          <CardMedia
            component="img"
            height="194"
            alt={hotel.name}
          />
          <CardContent>
            <Typography variant="body2" color="text.secondary">
              {hotel.description}
            </Typography>
          </CardContent>
          <CardActions disableSpacing>
            <ButtonGroup variant="contained" aria-label="Basic button group">
              <Button onClick={() => handleCheckInClick(hotel.id)}>CheckIn</Button>
            </ButtonGroup>
            <ExpandMore
              expand={expanded[hotel.id]}
              onClick={() => handleExpandClick(hotel.id)}
              aria-expanded={expanded[hotel.id]}
              aria-label="show more"
            >
              <ExpandMoreIcon />
            </ExpandMore>
          </CardActions>
          <Collapse in={expanded[hotel.id]} timeout="auto" unmountOnExit>
            <CardContent>
              <Typography paragraph>Details:</Typography>
              <Typography paragraph>
                {hotel.details}
              </Typography>
            </CardContent>
          </Collapse>
        </Card>
      ))}
    </>
  );
}
