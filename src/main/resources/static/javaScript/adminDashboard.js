function showHotelDetails(hotelId, hotelName) {
    // Fetch the modal element
    const modalTitle = document.getElementById('modalTitle');
    const roomList = document.getElementById('roomList');
    const roomTypeList = document.getElementById('roomTypeList');

    // Set the modal title
    modalTitle.innerText = hotelName;

    // Clear existing content
    roomList.innerHTML = '';
    roomTypeList.innerHTML = '';

    // Use AJAX to fetch hotel details, rooms, and room types
    fetch(`/admin/hotels/${hotelId}/details`)
        .then(response => response.json())
        .then(data => {
            // Populate the modal body with hotel details
            data.rooms.forEach(room => {
                let listItem = document.createElement('li');
                listItem.textContent = `Room ${room.roomNumber} - ${room.roomType.name}, $${room.price}`;
                roomList.appendChild(listItem);
            });

            data.roomTypes.forEach(roomType => {
                let listItem = document.createElement('li');
                listItem.textContent = `${roomType.name}: ${roomType.description}`;
                roomTypeList.appendChild(listItem);
            });

            // Show the modal
            document.getElementById('hotelModal').classList.remove('hidden');
        })
        .catch(error => {
            console.error('Error fetching hotel details:', error);
        });
}